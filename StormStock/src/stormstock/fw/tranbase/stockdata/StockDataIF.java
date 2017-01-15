package stormstock.fw.tranbase.stockdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stormstock.fw.base.BLog;
import stormstock.fw.base.BUtilsDateTime;
import stormstock.fw.tranbase.account.AccountAccessor;
import stormstock.ori.stockdata.DataEngine;
import stormstock.ori.stockdata.DataEngineBase;
import stormstock.ori.stockdata.DataWebStockRealTimeInfo;
import stormstock.ori.stockdata.DataEngine.ExKData;
import stormstock.ori.stockdata.DataEngineBase.StockBaseInfo;
import stormstock.ori.stockdata.DataWebStockAllList.StockItem;
import stormstock.ori.stockdata.DataWebStockDayK.DayKData;
import stormstock.ori.stockdata.DataWebStockRealTimeInfo.RealTimeInfo;

/*
 * 注意：取得的数据均为前复权价格
 */

public class StockDataIF {
	
	public StockDataIF()
	{
	}
	
	/*
	 * 获得某日期时间的账户访问器
	 * 可以获取账户信息
	 */
	public StockDataAccessor getStockDataAccessor(String date, String time)
	{
		return new StockDataAccessor(date, time, this);
	}
	
	/*
	 * 更新所有股票数据
	 * s_localLatestDate为缓存最新数据日期，此日期大于等于要更新日时，不做事情
	 * 真正数据更新执行后，所有缓存清空
	 */
	public boolean updateAllLocalStocks(String dateStr)
	{
		if(null == m_localLatestDate)
		{
			BLog.output("STOCKDATA","DataEngine.getUpdatedStocksDate\n");
			m_localLatestDate =  DataEngine.getUpdatedStocksDate();
		}
		
		if(m_localLatestDate.compareTo(dateStr) >= 0)
		{
			BLog.output("STOCKDATA", "update success! (current is newest, local: %s)\n", m_localLatestDate);
		}
		else
		{
			int iUpdateCnt = DataEngine.updateAllLocalStocks(dateStr);
			BLog.output("STOCKDATA", "update success to date: %s (count: %d)\n", m_localLatestDate, iUpdateCnt);
			clearAllCache();
		}
		
		return true;
	}
	/*
	 * 更新单只股票数据
	 * 此方法不改变s_localLatestDate
	 */
	public boolean updateLocalStocks(String stockID, String dateStr)
	{
		if(null == m_localLatestDate)
		{
			BLog.output("STOCKDATA","DataEngine.getUpdatedStocksDate\n");
			m_localLatestDate =  DataEngine.getUpdatedStocksDate();
		}
		if(m_localLatestDate.compareTo(dateStr) >= 0)
		{
			BLog.output("STOCKDATA", "update %s success! (current is newest, local: %s)\n",stockID, m_localLatestDate);
		}
		else
		{
			// 更新单只股票数据 不影响s_localLatestDate
			int iUpdateCnt = DataEngine.updateStock(stockID);
			String updatedDate = DataEngine.getUpdatedStocksDate();
			BLog.output("STOCKDATA", "update %s success to date: %s (count: %d)\n", stockID, updatedDate, iUpdateCnt);
		}
		return true;
	}
	
	/*
	 * 获取所有股票Id列表
	 * 基于当前本地数据获取，不保证是最新（依赖于数据更新）
	 */
	public List<String> getAllStockID()
	{
		if(null != m_cache_allStockID)
		{
			return m_cache_allStockID;
		}
		else
		{
			m_cache_allStockID = new ArrayList<String>();
			
			List<StockItem> cStockList = DataEngine.getLocalAllStock();
			
			for(int i=0; i<cStockList.size();i++)
			{
				String stockId = cStockList.get(i).id;
				m_cache_allStockID.add(stockId);
			}
			return m_cache_allStockID;
		}
	}

	/*
	 * 获取某只股票基本信息
	 * 不保证是最新（依赖于数据更新）
	 */
	public StockInfo getLatestStockInfo(String id)
	{
		// 首次进行缓存
		if(null == m_cache_latestStockInfo || !m_cache_latestStockInfo.containsKey(id))
		{
			if(null == m_cache_latestStockInfo)
			{
				m_cache_latestStockInfo = new HashMap<String,StockInfo>();
			}
			
			StockInfo cStockInfo = new StockInfo();
			cStockInfo.ID = id;
			
			StockBaseInfo cStockBaseInfo = new StockBaseInfo();
			if(0 == DataEngine.getStockBaseData(id, cStockBaseInfo))
			{
				cStockInfo.name = cStockBaseInfo.name;
				cStockInfo.allMarketValue = cStockBaseInfo.allMarketValue; 
				cStockInfo.circulatedMarketValue = cStockBaseInfo.circulatedMarketValue; 
				cStockInfo.peRatio = cStockBaseInfo.peRatio;
			}
			m_cache_latestStockInfo.put(id, cStockInfo);
		}
			
		// 从缓存中取数据
		if(null != m_cache_latestStockInfo && m_cache_latestStockInfo.containsKey(id))
		{
			return m_cache_latestStockInfo.get(id);
		}
		else
		{
			return null;
		}
	}
	
	/*
	 * 获取某只股票的历史日K数据
	 * 不保证是最新（依赖于数据更新）
	 */
	public List<StockDay> getHistoryData(String stockID, String fromDate, String endDate)
	{
		// 首次进行历史数据缓存
		if(null == s_cache_stockDayData || !s_cache_stockDayData.containsKey(stockID))
		{
			if(null == s_cache_stockDayData)
			{
				s_cache_stockDayData = new HashMap<String,List<StockDay>>();
			}
			
			List<StockDay> historyData = new ArrayList<StockDay>();
			
			List<DayKData> retList = new ArrayList<DayKData>();
			int ret = DataEngine.getDayKDataQianFuQuan(stockID, retList);
			
			if(0 == ret && retList.size() != 0)
			{
				for(int i = 0; i < retList.size(); i++)  
		        {  
					DayKData cDayKData = retList.get(i);  
	
					StockDay cStockDay = new StockDay();
					cStockDay.set(cDayKData.date, 
							cDayKData.open, cDayKData.close, cDayKData.low, cDayKData.high, cDayKData.volume);
					//System.out.println("historyData.add " + cDayKData.date + "," + cDayKData.open + "," + cDayKData.close); 
					historyData.add(cStockDay);
		        } 
			}
			
//			BLog.output("TEST", "DataEngine getDayKDataQianFuQuan(%d)\n", retList.size());
//			BLog.output("TEST", "getHistoryData return! historyData(%d)\n", historyData.size());
			
			s_cache_stockDayData.put(stockID, historyData);
		}
		
		// 从缓存中取数据
		if(null != s_cache_stockDayData && s_cache_stockDayData.containsKey(stockID))
		{
			List<StockDay> cacheList = s_cache_stockDayData.get(stockID);
			return StockUtils.subStockDayData(cacheList, fromDate, endDate);
		}
		else
		{
			return null;
		}
	}
	
	public List<StockDay> getHistoryData(String id, String endDate)
	{
		return getHistoryData(id, "2000-01-01", endDate);
	}
	public List<StockDay> getHistoryData(String id)
	{
		return getHistoryData(id, "2000-01-01", "2100-01-01");
	}

	/*
	 * 获取某只股票某天某时间的价格
	 */
	public boolean getStockTime(String id, String date, String time, StockTime out_cStockTime)
	{
		boolean bRealTime = false;
		String curDate = BUtilsDateTime.GetCurDateStr();
		String curTime = "";
		if(date.compareTo(curDate) == 0)
		{
			curTime = BUtilsDateTime.GetCurTimeStr();
			if(Math.abs(BUtilsDateTime.subTime(time,curTime)) < 10) // 离当前时间10秒内
			{
				bRealTime = true;
			}
		}
		
		if(bRealTime)
		{
			RealTimeInfo cRealTimeInfo = new RealTimeInfo();
			int ret = DataWebStockRealTimeInfo.getRealTimeInfo(id, cRealTimeInfo);
			if(0 == ret)
			{
				out_cStockTime.time = curTime;
				out_cStockTime.price = cRealTimeInfo.curPrice;
				return true;
			}
		}
		else
		{
			// 模拟
			// 9点30（不含）之前，为前一天收盘价格
			// 09:30:00 - 13:00:00（不含） ，为上午开盘价格
			// 13:00:00 - 24:00:00 （含），为下午收盘价格
			if(time.compareTo("09:30:00") >= 0)
			{
				List<StockDay> cStockDayList = getHistoryData(id, date, date);
				if(cStockDayList.size() > 0)
				{
					StockDay cStockDay = cStockDayList.get(0);
					float open = cStockDay.open();
					float close = cStockDay.close();
					out_cStockTime.time = time;
					if(time.compareTo("09:30:00") >= 0 && time.compareTo("13:00:00") < 0)
					{
						out_cStockTime.price = open;
					}
					else if(time.compareTo("13:00:00") >= 0 && time.compareTo("24:00:00") <= 0)
					{
						out_cStockTime.price = close;
					}
					return true;
				}
			}
			else
			{
				String beforeDate = BUtilsDateTime.getDateStrForSpecifiedDateOffsetD(date, -1);
				List<StockDay> cStockDayList = getHistoryData(id, beforeDate, beforeDate);
				if(cStockDayList.size() > 0)
				{
					StockDay cStockDay = cStockDayList.get(0);
					out_cStockTime.time = time;
					out_cStockTime.price = cStockDay.close();
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * 获取某只股票某天某时间的细节数据
	 */
//	public List<StockTime> getDayDetail(String id, String date, String endTime)
//	{
//		List<StockTime> detailDataList = new ArrayList<StockTime>();
//		
//		List<StockDay> historyData = getHistoryData(id, date, date);
//		if(historyData.size()==1)
//		{
//			StockDay cStockDay = historyData.get(0);
//			
//			if(null != cStockDay && date.length() == "0000-00-00".length())
//			{
//				// load new detail data
//				List<ExKData> retList = new ArrayList<ExKData>();
//				int ret = DataEngine.get1MinKDataOneDay(id, date, retList);
//				if(0 == ret && retList.size() != 0)
//				{
//					// 由于可能是复权价位，需要重新计算相对价格
//					float baseOpenPrice = cStockDay.open();
//					float actruaFirstPrice = retList.get(0).open;
//					for(int i = 0; i < retList.size(); i++)  
//			        {  
//						ExKData cExKData = retList.get(i);  
////			            System.out.println(cExKData.datetime + "," 
////			            		+ cExKData.open + "," + cExKData.close + "," 
////			            		+ cExKData.low + "," + cExKData.high + "," 
////			            		+ cExKData.volume);  
//						
//						float actrualprice = cExKData.close;
//						float changeper = (actrualprice - actruaFirstPrice)/actruaFirstPrice;
//						float changedprice = baseOpenPrice + baseOpenPrice * changeper;
//						
//						if(cExKData.getTime().compareTo(endTime) <= 0) //只添加小于时间参数的
//						{
//							StockTime cStockDayDetail = new StockTime();
//							cStockDayDetail.price = changedprice;
//							cStockDayDetail.time = cExKData.getTime();
//							detailDataList.add(cStockDayDetail);
//						}
//			        } 
//				}
//			}
//		}
//		
//		return detailDataList;
//	}
//	public List<StockTime> getDayDetail(String id, String date)
//	{
//		return getDayDetail(id, date, "15:00:00");
//	}
//	public void cacheDayDetail(String id, String date, List<StockTime> cStockTimeList)
//	{
//		if(null == s_cache_stockTimeData)
//		{
//			s_cache_stockTimeData = new HashMap<String, List<StockTime>>();
//		}
//		String key = id + "_" + date;
//		s_cache_stockTimeData.put(key, cStockTimeList);
//	}
//	public boolean isCachedDayDetailData(String id, String date) 
//	{
//		if(null == s_cache_stockTimeData) return false;
//		String key = id + "_" + date;
//		if(!s_cache_stockTimeData.containsKey(key)) return false;
//		return true;
//	}
	
	// ******************************************************************************************
	
//	public Stock getStock(String id, String fromDate, String endDate)
//	{
//		boolean bEnableCache = false;
//		
//		// cache check
//		if(bEnableCache)
//		{
//			String endDateActual = endDate;
//			String fromDateActual = fromDate;
//			if(null == s_localLatestDate)
//			{
//				s_localLatestDate = DataEngine.getUpdatedStocksDate();
//			}
//			if(endDateActual.compareTo(s_localLatestDate) > 0)
//			{
//				endDateActual = s_localLatestDate;
//			}
//			if(fromDateActual.compareTo("2008-01-01") < 0)
//			{
//				fromDateActual = "2008-01-01";
//			}
//			if(s_stockCacheMap.containsKey(id))
//			{
//				Stock cStock = s_stockCacheMap.get(id);
//				if(fromDateActual.compareTo("2008-01-01")>=0 && 
//						endDateActual.compareTo(s_localLatestDate) <=0)
//				{
//					Stock cNewStock = cStock.subObj(fromDate, endDate);
//					return cNewStock;
//				}
//				else
//				{
//					s_stockCacheMap.remove(id);
//				}
//			}
//		}
//		
//		List<DayKData> retList = new ArrayList<DayKData>();
//		int ret = DataEngine.getDayKDataQianFuQuan(id, retList);
//		if(0 != ret || retList.size() == 0)
//		{
//			return null;
//		}
//			
//		Stock cStock = new Stock();
//		
//		StockInfo cStockInfo = getLatestStockInfo(id);
//		cStock.getCurLatestStockInfo().CopyFrom(cStockInfo);
//		
//		for(int i = 0; i < retList.size(); i++)  
//        {  
//			DayKData cDayKData = retList.get(i);  
//			if(cDayKData.date.compareTo(fromDate) >= 0
//					&& cDayKData.date.compareTo(endDate) <= 0)
//			{
//				StockDay cStockDay = new StockDay();
//				cStockDay.set(cDayKData.date, 
//						cDayKData.open, cDayKData.close, cDayKData.low, cDayKData.high, cDayKData.volume);
////		            System.out.println(cDayKData.date + "," 
////		            		+ cDayKData.open + "," + cDayKData.close); 
//				cStock.getCurStockDayData().add(cStockDay);
//			}
//        } 
//		
//		// cache
////		if(bEnableCache)
////		{
////			s_stockCacheMap.put(id, cStock);
////		}
//		
//		return cStock;
//	}

	
	// ***********************************************************************************
	
	public void clearAllCache()
	{
		m_localLatestDate = null;
		m_cache_allStockID = null;
		s_cache_stockDayData = null;
	}
	
	// 当前总数据最新更新日期缓存
	private String m_localLatestDate = null;
	// 本地股票列表缓存
	private List<String> m_cache_allStockID = null;
	// 本地股票最新基本信息缓存
	private Map<String,StockInfo> m_cache_latestStockInfo = null;
	private Map<String,List<StockDay>> s_cache_stockDayData = null;
}
