package stormstock.fw.report;

import java.util.ArrayList;
import java.util.List;

import stormstock.fw.base.BEventSys;
import stormstock.fw.base.BLog;
import stormstock.fw.base.BQThread.BQThreadRequest;
import stormstock.fw.base.BImageCurve;
import stormstock.fw.event.ReportAnalysis;
import stormstock.fw.tranbase.account.AccountControlIF;
import stormstock.fw.tranbase.account.AccountPublicDef.DeliveryOrder;
import stormstock.fw.tranbase.account.AccountPublicDef.HoldStock;
import stormstock.fw.tranbase.account.AccountPublicDef.TRANACT;
import stormstock.fw.tranbase.com.GlobalUserObj;
import stormstock.fw.tranbase.stockdata.StockDataIF;
import stormstock.fw.tranbase.stockdata.StockDay;
import stormstock.fw.tranbase.stockdata.StockDataIF.ResultHistoryData;
import stormstock.fw.base.BImageCurve.CurvePoint;
import stormstock.fw.report.InfoCollector.DailyReport;

public class TranInfoCollectWorkRequest extends BQThreadRequest {
	
	public TranInfoCollectWorkRequest(String date, String time, InfoCollector cInfoCollector)
	{
		m_date = date;
		m_time = time;
		m_cInfoCollector = cInfoCollector;
	}

	@Override
	public void doAction() {
		BLog.output("REPORT", "TranInfoCollectWorkRequest.doAction [%s %s]\n", m_date, m_time);
		
		StockDataIF cStockDataIF = GlobalUserObj.getCurStockDataIF();
		AccountControlIF cAccountControlIF = GlobalUserObj.getCurAccountControlIF();
		
		// 创建DailyReport
		DailyReport cDailyReport = new DailyReport(m_date);
		
		// 添加当天上证指数
		ResultHistoryData cResultHistoryData = cStockDataIF.getHistoryData("999999", m_date, m_date);
		List<StockDay> cSHCompositeList = cResultHistoryData.resultList;
		cDailyReport.fSHComposite = cSHCompositeList.get(0).close();
		
		
		float fTotalAssets = cAccountControlIF.getTotalAssets(m_date, m_time);
		float fAvailableMoney = cAccountControlIF.getAvailableMoney();
		List<HoldStock> cHoldStockList = cAccountControlIF.getHoldStockList(m_date, m_time);
		List<DeliveryOrder> cDeliveryOrderList = cAccountControlIF.getDeliveryOrderList();
		
		// 添加当前总资产，可用钱
		cDailyReport.fTotalAssets = fTotalAssets;
		cDailyReport.fAvailableMoney = fAvailableMoney;
		
		BLog.output("REPORT", "    -TotalAssets: %.3f\n", fTotalAssets);
		BLog.output("REPORT", "    -AvailableMoney: %.3f\n", fAvailableMoney);
		for(int i=0; i<cHoldStockList.size(); i++ )
		{
			HoldStock cHoldStock = cHoldStockList.get(i);
			BLog.output("REPORT", "    -HoldStock: %s %s %s %.3f %.3f %d %.3f(%.3f) %d\n", 
					cHoldStock.stockID, cHoldStock.createDate, cHoldStock.createTime,
					cHoldStock.holdAvePrice, cHoldStock.curPrice, cHoldStock.totalAmount,
					cHoldStock.curPrice*cHoldStock.totalAmount, cHoldStock.transactionCost,
					cHoldStock.holdDayCnt);
		}
		for(int i=0; i<cDeliveryOrderList.size(); i++ )
		{
			DeliveryOrder cDeliveryOrder = cDeliveryOrderList.get(i);
			String tranOpe = "BUY"; 
			if(cDeliveryOrder.tranAct == TRANACT.SELL ) tranOpe = "SELL";
				
			BLog.output("REPORT", "    -DeliveryOrder: %s %s %s %s %.3f %.3f %d %.3f(%.3f)\n", 
					cDeliveryOrder.date, cDeliveryOrder.time,
					tranOpe, cDeliveryOrder.stockID, 
					cDeliveryOrder.holdAvePrice, cDeliveryOrder.tranPrice, cDeliveryOrder.amount,
					cDeliveryOrder.tranPrice*cDeliveryOrder.amount, cDeliveryOrder.transactionCost);
			
			// 判断清仓交割单
			boolean bIsClearDeliveryOrder = false;
			for(int j=0; j<cHoldStockList.size(); j++ )
			{
				HoldStock cHoldStock = cHoldStockList.get(j);
				if(cHoldStock.stockID.equals(cDeliveryOrder.stockID))
				{
					bIsClearDeliveryOrder = false;
					break;
				}
			}
			if(bIsClearDeliveryOrder)
			{
				// 添加清仓交割单
				cDailyReport.cClearDeliveryOrder.add(cDeliveryOrder);
			}
		}
		
		// 添加DailyReport
		m_cInfoCollector.addDailyReport(cDailyReport);
		
		ReportAnalysis.TranInfoCollectCompleteNotify.Builder msg_builder = ReportAnalysis.TranInfoCollectCompleteNotify.newBuilder();
		msg_builder.setDate(m_date);
		msg_builder.setTime(m_time);

		ReportAnalysis.TranInfoCollectCompleteNotify msg = msg_builder.build();
		BEventSys.EventSender cSender = new BEventSys.EventSender();
		cSender.Send("BEV_TRAN_TRANINFOCOLLECTCOMPLETENOTIFY", msg);
	}

	private String m_date;
	private String m_time;
	
	private InfoCollector m_cInfoCollector;
}
