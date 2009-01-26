package org.jsecretsharing;

import java.math.BigInteger;
import java.util.List;

public class ShareCombiner {
	private final BigInteger[] xValues, yValues;
	
	public ShareCombiner(List<Share> shares) {
		this.xValues = new BigInteger[shares.size()];
		this.yValues = new BigInteger[shares.size()];
		for (int i = 0; i < shares.size(); i++) {
			xValues[i] = shares.get(i).getX();
			yValues[i] = shares.get(i).getY();
		}
	}

	public byte[] combine() {
		LaGrangeInterpolator interpolator = new LaGrangeInterpolator(xValues, yValues);
		return interpolator.interpolate(BigInteger.ZERO).toByteArray();
	}
	
	
}
