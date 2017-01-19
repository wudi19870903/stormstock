package stormstock.fw.tranbase.account;

import java.util.ArrayList;
import java.util.List;

import stormstock.fw.tranbase.account.AccountPublicDef.CommissionOrder;
import stormstock.fw.tranbase.account.AccountPublicDef.DeliveryOrder;
import stormstock.fw.tranbase.account.AccountPublicDef.HoldStock;
import stormstock.fw.tranbase.account.AccountPublicDef.TRANACT;
import stormstock.fw.tranbase.stockdata.StockDataIF;
import stormstock.fw.tranbase.stockdata.StockTime;

public class AccountEntity {
	
	// �����˻�ʵ��ʱ����Ҫ��������ӿڣ�ģ�⣬��ʵ��
	public AccountEntity(IAccountOpe cIAccountOpe)
	{
		m_cIAccountOpe = cIAccountOpe;
	}
	
	// ***********************************************************************
	// �����ӿڣ�ֱ�ӵ��ò����ӿ�
	
	// ���տ�ʼ�˻���ʼ��
	public boolean newDayInit()
	{
		return m_cIAccountOpe.newDayInit();
	}
	
	// ������ί�У�����ʵ���µ���
	public int pushBuyOrder(String date, String time, String id, float price, int amount)
	{
		return m_cIAccountOpe.pushBuyOrder(date, time, id, price, amount);
	}
	
	// ��������ί�У�����ʵ���µ���
	public int pushSellOrder(String date, String time, String id, float price, int amount)
	{
		return m_cIAccountOpe.pushSellOrder(date, time, id, price, amount);
	}
	
	// ����˻������ʽ��ֽ�
	public float getAvailableMoney()
	{
		return m_cIAccountOpe.getAvailableMoney();
	}
	
	// ���ί���б�(δ�ɽ��ģ����������������)
	public List<CommissionOrder> getCommissionOrderList()
	{
		return m_cIAccountOpe.getCommissionOrderList();
	}
	
	// ��óֹ��б��������Ѿ����еģ��뵱���µ��ɽ��ģ�
	public List<HoldStock> getHoldStockList(String date, String time)
	{
		return m_cIAccountOpe.getHoldStockList(date, time);
	}
	
	// ��õ��ս���б����ѳɽ��ģ���������������ģ�
	public List<DeliveryOrder> getDeliveryOrderList()
	{
		return m_cIAccountOpe.getDeliveryOrderList();
	}
		
	
	// ***********************************************************************
	// ��չ�ӿڣ�����ʵ���ڻ�������֮�ϵ���չ
	
	// �����ί���б�(δ�ɽ���)
	public List<CommissionOrder> getBuyCommissionOrderList()
	{
		List<CommissionOrder> cBuyCommissionOrderList = new ArrayList<CommissionOrder>();
		List<CommissionOrder> cCommissionOrderList = getCommissionOrderList();
		for(int i= 0;i<cCommissionOrderList.size();i++)
		{
			CommissionOrder cCommissionOrder = cCommissionOrderList.get(i);
			if(cCommissionOrder.tranOpe == TRANACT.BUY)
			{
				CommissionOrder cNewCommissionOrder = new CommissionOrder();
				cNewCommissionOrder.CopyFrom(cCommissionOrder);
				cBuyCommissionOrderList.add(cNewCommissionOrder);
			}
		}
		return cBuyCommissionOrderList;
	}
	
	// �����ί���б�(δ�ɽ���)
	public List<CommissionOrder> getSellCommissionOrderList()
	{
		List<CommissionOrder> cSellCommissionOrderList = new ArrayList<CommissionOrder>();
		List<CommissionOrder> cCommissionOrderList = getCommissionOrderList();
		for(int i= 0;i<cCommissionOrderList.size();i++)
		{
			CommissionOrder cCommissionOrder = cCommissionOrderList.get(i);
			if(cCommissionOrder.tranOpe == TRANACT.SELL)
			{
				CommissionOrder cNewCommissionOrder = new CommissionOrder();
				cNewCommissionOrder.CopyFrom(cCommissionOrder);
				cSellCommissionOrderList.add(cNewCommissionOrder);
			}
		}
		return cSellCommissionOrderList;
	}
	
	// ����򽻸�б�(�ѳɽ���)
	public List<DeliveryOrder> getBuyDeliveryOrderList()
	{
		List<DeliveryOrder> cBuyDeliveryOrderList = new ArrayList<DeliveryOrder>();
		List<DeliveryOrder> cDeliveryOrderList = getDeliveryOrderList();
		for(int i= 0;i<cDeliveryOrderList.size();i++)
		{
			DeliveryOrder cDeliveryOrder = cDeliveryOrderList.get(i);
			if(cDeliveryOrder.tranOpe == TRANACT.BUY)
			{
				DeliveryOrder cNewDeliveryOrder = new DeliveryOrder();
				cNewDeliveryOrder.CopyFrom(cDeliveryOrder);
				cBuyDeliveryOrderList.add(cNewDeliveryOrder);
			}
		}
		return cBuyDeliveryOrderList;
	}
	
	// ���������б�(�ѳɽ���)
	public List<DeliveryOrder> getSellDeliveryOrderList()
	{
		List<DeliveryOrder> cSellDeliveryOrderList = new ArrayList<DeliveryOrder>();
		List<DeliveryOrder> cDeliveryOrderList = getDeliveryOrderList();
		for(int i= 0;i<cDeliveryOrderList.size();i++)
		{
			DeliveryOrder cDeliveryOrder = cDeliveryOrderList.get(i);
			if(cDeliveryOrder.tranOpe == TRANACT.SELL)
			{
				DeliveryOrder cNewDeliveryOrder = new DeliveryOrder();
				cNewDeliveryOrder.CopyFrom(cDeliveryOrder);
				cSellDeliveryOrderList.add(cNewDeliveryOrder);
			}
		}
		return cSellDeliveryOrderList;
	}
	
	// ����˻����ʲ�
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

	/** **********************************************************************
	 * �˻������ӿڣ���������Ϊģ�����ʵ
	 */
	private IAccountOpe m_cIAccountOpe;
}