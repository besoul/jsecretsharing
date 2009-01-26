package org.jsecretsharing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class LaGrangeInterpolator {
	private final BigDecimal[] xValues, yValues;
	private final int degree;
	
	public LaGrangeInterpolator(BigInteger[] xValues, BigInteger[] yValues) {
		if (xValues.length != yValues.length) {
			throw new IllegalArgumentException("must be the same number of X values as Y values");
		}
		
		this.degree = xValues.length;
		this.xValues = new BigDecimal[degree];
		this.yValues = new BigDecimal[degree];
		for (int i = 0; i < degree; i++) {
			this.xValues[i] = new BigDecimal(xValues[i]);
			this.yValues[i] = new BigDecimal(yValues[i]);
		}
	}

	public BigInteger interpolate(BigInteger x) {
		BigDecimal value = BigDecimal.ZERO;
		BigDecimal desiredPos = new BigDecimal(x);
		for (int i = 0; i < degree; i++) {
			BigDecimal weight = BigDecimal.ONE;
			for (int j = 0; j < degree; j++) {
				if (j != i) {
					BigDecimal top = desiredPos.subtract(xValues[j]);
					BigDecimal bottom = xValues[i].subtract(xValues[j]);
					BigDecimal factor = top.divide(bottom, 3000, RoundingMode.HALF_EVEN);
					weight = weight.multiply(factor);
				}
			}
			value = value.add(weight.multiply(yValues[i]));
		}
		return value.toBigInteger();
	}
}
