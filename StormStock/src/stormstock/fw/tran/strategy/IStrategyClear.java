package stormstock.fw.tran.strategy;

abstract public class IStrategyClear {
	// 清仓下单策略
	public static class ClearResult {
		public ClearResult() {
			bClear = false;
		}
		public boolean bClear; // 清仓标志
	}
	abstract public void strategy_clear(StockContext ctx, ClearResult out_sr);
}
