package org.jsecretsharing.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.jsecretsharing.Share;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ShareTest {
	public static class A_New_Share {
		private final Share share = new Share(BigInteger.valueOf(20), BigInteger.ONE);
		
		@Test
		public void itHasAValueForTheXAxis() throws Exception {
			assertEquals(BigInteger.valueOf(20), share.getX());
		}
		
		@Test
		public void itHasAValueForTheYAxis() throws Exception {
			assertEquals(BigInteger.ONE, share.getY());
		}
		
		@Test
		public void itCanBeEncodedAsAString() throws Exception {
			assertEquals("14:01", share.toString());
		}
	}
	
	public static class Loading_A_Share {
		private final String data = "0a:01";
		
		@Test
		public void itLoadsTheXValue() throws Exception {
			assertEquals(BigInteger.TEN,Share.load(data).getX());
		}
	}
}
