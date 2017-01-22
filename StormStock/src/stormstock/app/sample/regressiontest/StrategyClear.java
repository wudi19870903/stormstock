package stormstock.app.sample.regressiontest;

import java.util.List;

import stormstock.fw.base.BLog;
import stormstock.fw.tranbase.account.AccountPublicDef.HoldStock;
import stormstock.fw.tranbase.com.IStrategyClear;
import stormstock.fw.tranbase.com.TranContext;
import stormstock.fw.tranbase.stockdata.Stock;
import stormstock.fw.tranbase.stockdata.StockTime;

public class StrategyClear extends IStrategyClear {

	@Override
	public void strategy_clear(TranContext ctx, ClearResult out_sr) {
		
		Stock curStock = ctx.target().stock();
		
		String stockID = ctx.target().stock().getCurLatestStockInfo().ID;
		String stockTimeStr = "";
		List<StockTime> stockTimeList = ctx.target().stock().getLatestStockTimeList();
		for(int i=0; i<stockTimeList.size(); i++)
		{
			StockTime cStockTime = stockTimeList.get(i);
			stockTimeStr = stockTimeStr + String.format("%.2f(%s) ", cStockTime.price, cStockTime.time);
		}
		
//		BLog.output("TEST", "        [%s %s] strategy_create stockID:%s (%s)  %s\n", 
//				ctx.date(), ctx.time(), 
//				curStock.getCurLatestStockInfo().ID, curStock.GetLastDate() , stockTimeStr);
		
		HoldStock cHoldStock = ctx.target().holdStock();
		if(cHoldStock.holdDayCnt > 10) // 持股天数大于10 卖出
		{
			out_sr.bClear = true;
		}
			
		if(cHoldStock.profitRatio() > 0.02 || cHoldStock.profitRatio() < -0.02)
		{
			out_sr.bClear = true;
		}
		
//		if(out_sr.bClear)
//		{
//			BLog.output("TEST", "        HoldStock %s %.2f %d\n", stockID, cHoldStock.curPrice, cHoldStock.holdDayCnt);
//		}
	}

}
