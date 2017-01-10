package stormstock.app.sample.regressiontest;

import stormstock.fw.tranbase.com.IStrategyClear;
import stormstock.fw.tranbase.com.StockContext;

public class StrategyClear extends IStrategyClear {

	@Override
	public void strategy_clear(StockContext ctx, ClearResult out_sr) {
		// TODO Auto-generated method stub
		out_sr.bClear = true;
	}

}