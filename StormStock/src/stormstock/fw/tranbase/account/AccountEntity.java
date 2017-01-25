package stormstock.fw.tranbase.account;

import java.util.ArrayList;
import java.util.List;

import stormstock.fw.base.BLog;
import stormstock.fw.tranbase.account.AccountPublicDef.ACCOUNTTYPE;
import stormstock.fw.tranbase.account.AccountPublicDef.CommissionOrder;
import stormstock.fw.tranbase.account.AccountPublicDef.DeliveryOrder;
import stormstock.fw.tranbase.account.AccountPublicDef.HoldStock;
import stormstock.fw.tranbase.account.AccountPublicDef.TRANACT;
import stormstock.fw.tranbase.stockdata.StockDataIF;
import stormstock.fw.tranbase.stockdata.StockTime;

public class AccountEntity {
	
	// 构造账户实体时，需要传入操作接口（模拟，真实）
	public AccountEntity(ACCOUNTTYPE eAccType, String accountID, String password)
	{
		IAccountOpe cIAccountOpe = null;
		if(eAccType == ACCOUNTTYPE.MOCK)
		{
			cIAccountOpe = new MockAccountOpe(accountID, password, true);
		} 
		else if(eAccType == ACCOUNTTYPE.REAL)
		{
			cIAccountOpe = new RealAccountOpe(accountID, password);
		}
		m_cIAccountOpe = cIAccountOpe;
	}
	
	// ***********************************************************************
	// 基本接口，直接调用操作接口
	
	// 隔日开始账户初始化
	public boolean newDayInit(String date, String time)
	{
		return m_cIAccountOpe.newDayInit(date, time);
	}
	
	// 推送买单委托，返回实际下单量
	public int pushBuyOrder(String date, String time, String id, float price, int amount)
	{
		return m_cIAccountOpe.pushBuyOrder(date, time, id, price, amount);
	}
	
	// 推送卖单委托，返回实际下单量
	public int pushSellOrder(String date, String time, String id, float price, int amount)
	{
		return m_cIAccountOpe.pushSellOrder(date, time, id, price, amount);
	}
	
	// 获得账户可用资金（现金）
	public float getAvailableMoney()
	{
		return m_cIAccountOpe.getAvailableMoney();
	}
	
	// 获得委托列表(未成交的，包含买入和卖出的)
	public List<CommissionOrder> getCommissionOrderList()
	{
		return m_cIAccountOpe.getCommissionOrderList();
	}
	
	// 获得持股列表（包含已经持有的，与当天下单成交的）
	public List<HoldStock> getHoldStockList(String date, String time)
	{
		return m_cIAccountOpe.getHoldStockList(date, time);
	}
	
	// 获得当日交割单列表（已成交的，包含买入和卖出的）
	public List<DeliveryOrder> getDeliveryOrderList()
	{
		return m_cIAccountOpe.getDeliveryOrderList();
	}
		
	// ***********************************************************************
	// 扩展接口，用于实现在基础功能之上的扩展
	
	// 选股列表设置
	public void setStockSelectList(List<String> stockIDList)
	{
		m_cIAccountOpe.setStockSelectList(stockIDList);
	}
	// 选股列表获取
	public List<String> getStockSelectList()
	{
		return m_cIAccountOpe.getStockSelectList();
	}

	// 获得买委托列表(未成交的)
	public List<CommissionOrder> getBuyCommissionOrderList()
	{
		List<CommissionOrder> cBuyCommissionOrderList = new ArrayList<CommissionOrder>();
		List<CommissionOrder> cCommissionOrderList = getCommissionOrderList();
		for(int i= 0;i<cCommissionOrderList.size();i++)
		{
			CommissionOrder cCommissionOrder = cCommissionOrderList.get(i);
			if(cCommissionOrder.tranAct == TRANACT.BUY)
			{
				CommissionOrder cNewCommissionOrder = new CommissionOrder();
				cNewCommissionOrder.CopyFrom(cCommissionOrder);
				cBuyCommissionOrderList.add(cNewCommissionOrder);
			}
		}
		return cBuyCommissionOrderList;
	}
	
	// 获得卖委托列表(未成交的)
	public List<CommissionOrder> getSellCommissionOrderList()
	{
		List<CommissionOrder> cSellCommissionOrderList = new ArrayList<CommissionOrder>();
		List<CommissionOrder> cCommissionOrderList = getCommissionOrderList();
		for(int i= 0;i<cCommissionOrderList.size();i++)
		{
			CommissionOrder cCommissionOrder = cCommissionOrderList.get(i);
			if(cCommissionOrder.tranAct == TRANACT.SELL)
			{
				CommissionOrder cNewCommissionOrder = new CommissionOrder();
				cNewCommissionOrder.CopyFrom(cCommissionOrder);
				cSellCommissionOrderList.add(cNewCommissionOrder);
			}
		}
		return cSellCommissionOrderList;
	}
	
	// 获得买交割单列表(已成交的)
	public List<DeliveryOrder> getBuyDeliveryOrderList()
	{
		List<DeliveryOrder> cBuyDeliveryOrderList = new ArrayList<DeliveryOrder>();
		List<DeliveryOrder> cDeliveryOrderList = getDeliveryOrderList();
		for(int i= 0;i<cDeliveryOrderList.size();i++)
		{
			DeliveryOrder cDeliveryOrder = cDeliveryOrderList.get(i);
			if(cDeliveryOrder.tranAct == TRANACT.BUY)
			{
				DeliveryOrder cNewDeliveryOrder = new DeliveryOrder();
				cNewDeliveryOrder.CopyFrom(cDeliveryOrder);
				cBuyDeliveryOrderList.add(cNewDeliveryOrder);
			}
		}
		return cBuyDeliveryOrderList;
	}
	
	// 获得卖交割单列表(已成交的)
	public List<DeliveryOrder> getSellDeliveryOrderList()
	{
		List<DeliveryOrder> cSellDeliveryOrderList = new ArrayList<DeliveryOrder>();
		List<DeliveryOrder> cDeliveryOrderList = getDeliveryOrderList();
		for(int i= 0;i<cDeliveryOrderList.size();i++)
		{
			DeliveryOrder cDeliveryOrder = cDeliveryOrderList.get(i);
			if(cDeliveryOrder.tranAct == TRANACT.SELL)
			{
				DeliveryOrder cNewDeliveryOrder = new DeliveryOrder();
				cNewDeliveryOrder.CopyFrom(cDeliveryOrder);
				cSellDeliveryOrderList.add(cNewDeliveryOrder);
			}
		}
		return cSellDeliveryOrderList;
	}
	
	// 获得账户总资产
	public float getTotalAssets(String date, String time) {
		
		float all_marketval = 0.0f;
		List<HoldStock> cHoldStockList = getHoldStockList(date, time);
		for(int i=0;i<cHoldStockList.size();i++)
		{
			HoldStock cHoldStock = cHoldStockList.get(i);
			all_marketval = all_marketval + cHoldStock.curPrice*cHoldStock.totalAmount;
		}
		float all_asset = all_marketval + getAvailableMoney();
		return all_asset;
	}
	
	public void printAccount(String date, String time)
	{
		BLog.output("ACCOUNT", "    ---ACCOUNT---INFO---\n");
		float fTotalAssets = this.getTotalAssets(date, time);
		float fAvailableMoney = this.getAvailableMoney();
		List<HoldStock> cStockHoldList = this.getHoldStockList(date, time);
		List<DeliveryOrder> cDeliveryOrderList = this.getDeliveryOrderList();
		
		BLog.output("ACCOUNT", "    -TotalAssets: %.3f\n", fTotalAssets);
		BLog.output("ACCOUNT", "    -AvailableMoney: %.3f\n", fAvailableMoney);
		for(int i=0; i<cStockHoldList.size(); i++ )
		{
			HoldStock cHoldStock = cStockHoldList.get(i);
			BLog.output("ACCOUNT", "    -HoldStock: %s %s %s %.3f %.3f %d %.3f(%.3f) %d\n", 
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
				
			BLog.output("ACCOUNT", "    -DeliveryOrder: %s %s %s %s %.3f %.3f %d %.3f(%.3f)\n", 
					cDeliveryOrder.date, cDeliveryOrder.time,
					tranOpe, cDeliveryOrder.stockID, 
					cDeliveryOrder.holdAvePrice, cDeliveryOrder.tranPrice, cDeliveryOrder.amount,
					cDeliveryOrder.tranPrice*cDeliveryOrder.amount, cDeliveryOrder.transactionCost);
		}
	}

	/** **********************************************************************
	 * 账户操作接口，可以设置为模拟或真实
	 */
	private IAccountOpe m_cIAccountOpe;
}
