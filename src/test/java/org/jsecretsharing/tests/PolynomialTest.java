package org.jsecretsharing.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.jsecretsharing.Polynomial;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class PolynomialTest {
	public static class A_Constant_Polynomial {
		// f(x) = 10
		// f(1) = 10
		private static Polynomial constantPolynomial = new Polynomial(10);

		@Test
		public void itEvaluatesToTheFirstCoefficient() throws Exception {
			assertEquals(BigInteger.TEN, constantPolynomial.evaluate(BigInteger.ONE));
		}
		
		@Test
		public void itShouldHaveOneCoefficient() throws Exception {
			assertEquals(1, constantPolynomial.getDegree());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			assertEquals("10", constantPolynomial.toString());
		}
	}
	
	public static class A_Linear_Polynomial {
		// f(x) = 3x + 10
		// f(2) = 3(2) + 10 = 6 + 10 = 16
		private final Polynomial linearPolynomial = new Polynomial(10, 3);

		@Test
		public void itEvaluatesToTheFirstCoefficientPlusTheSecondCoefficientTimesX() throws Exception {
			
			assertEquals(BigInteger.valueOf(16), linearPolynomial.evaluate(BigInteger.valueOf(2)));
		}
		
		@Test
		public void itShouldHaveTwoCoefficients() throws Exception {
			assertEquals(2, linearPolynomial.getDegree());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			assertEquals("3x + 10", linearPolynomial.toString());
		}
	}

	public static class A_Quadratic_Polynomial {
		// f(x) = 4x^2 + 3x + 10
		// f(2) = 4(2^2) + 3(2) + 10 = 4(4) + 6 + 10 = 16 + 6 + 10 = 32
		private final Polynomial quadraticPolynomial = new Polynomial(10, 3, 4);

		@Test
		public void itEvaluatesToTheFirstCoefficientPlusTheSecondCoefficientTimesXPlusTheThirdCoefficientTimesXSquared() throws Exception {
			assertEquals(BigInteger.valueOf(32), quadraticPolynomial.evaluate(BigInteger.valueOf(2)));
		}
		
		@Test
		public void itShouldHaveThreeCoefficients() throws Exception {
			assertEquals(3, quadraticPolynomial.getDegree());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			assertEquals("4x^2 + 3x + 10", quadraticPolynomial.toString());
		}
	}
	
	public static class A_Cubic_Polynomial {
		// f(x) = 10x^3 + 4x^2 + 3x + 10
		// f(3) = 10(3^3) + 4(3^2) + 3(3) + 10 = 10(27) + 4(9) + 9 + 10 = 270 + 36 + 9 + 10 = 325
		private final Polynomial cubicPolynomial = new Polynomial(10, 3, 4, 10);

		@Test
		public void itEvaluatesCorrectly() throws Exception {
			assertEquals(BigInteger.valueOf(325), cubicPolynomial.evaluate(BigInteger.valueOf(3)));
		}
		
		@Test
		public void itShouldHaveThreeCoefficients() throws Exception {
			assertEquals(4, cubicPolynomial.getDegree());
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			assertEquals("10x^3 + 4x^2 + 3x + 10", cubicPolynomial.toString());
		}
	}
	
	public static class A_Polynomial_With_Some_Zero_Coefficients {
		// f(x) = 4x^2 + 10
		// f(2) = 4(2^2) + 10 = 4(4) + 10 = 16 + 10 = 26
		private final Polynomial sparsePolynomial = new Polynomial(10, 0, 4);
		
		@Test
		public void itEvaluatesCorrectly() throws Exception {
			assertEquals(BigInteger.valueOf(26), sparsePolynomial.evaluate(BigInteger.valueOf(2)));
		}
		
		@Test
		public void itIsHumanReadable() throws Exception {
			assertEquals("4x^2 + 10", sparsePolynomial.toString());
		}
	}
}
