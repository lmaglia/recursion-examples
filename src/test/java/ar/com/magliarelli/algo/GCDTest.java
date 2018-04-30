/**
 * 
 */
package ar.com.magliarelli.algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.Assert;

/**
 * @author lucas
 *
 */
@RunWith(JUnit4.class)
public class GCDTest {
	@Test
	public void compareGCDs() {
		int[] a= new int [] {10,11,12,13,14,15,16,17,18,19,20};
		int[] b= new int[] {1,2,3,4,5,6,7,8,9,10,11};
		for (int i = 0; i < a.length; i++) {
			Assert.assertEquals(GCD.gcd(a[i], b[i]), GCD.iterativeGCD(a[i], b[i]));
		}
	}
}
