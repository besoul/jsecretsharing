package org.jsecretsharing.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.jsecretsharing.LaGrangeInterpolator;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class LaGrangeInterpolatorTest {
	public static class Interpolating_A_Linear_System {
		@Test
		public void itProducesAPolynomialForWhichAllPointsEvaluateCorrectly() throws Exception {
			// f(x) = x^2
			BigInteger x0 = BigInteger.valueOf(1);
			BigInteger x1 = BigInteger.valueOf(2);
			BigInteger x2 = BigInteger.valueOf(3);
			
			BigInteger y0 = BigInteger.valueOf(1);
			BigInteger y1 = BigInteger.valueOf(4);
			BigInteger y2 = BigInteger.valueOf(9);
			
			
			LaGrangeInterpolator interpolator = new LaGrangeInterpolator(new BigInteger[] { x0, x1, x2 }, new BigInteger[] { y0, y1, y2 });
			assertEquals(y0, interpolator.interpolate(x0));
			assertEquals(y1, interpolator.interpolate(x1));
			assertEquals(y2, interpolator.interpolate(x2));
		}
	}
	
	public static class Interpolating_An_Unmatched_Set_Of_Points {
		@Test
		public void itThrowsAnException() throws Exception {
			boolean exceptionThrown = false;
			try {
				new LaGrangeInterpolator(new BigInteger[] { BigInteger.ONE }, new BigInteger[] { BigInteger.ONE, BigInteger.TEN });
			} catch (IllegalArgumentException e) {
				exceptionThrown = true;
			}
			assertTrue("should have thrown an exception", exceptionThrown);
		}
	}
}
