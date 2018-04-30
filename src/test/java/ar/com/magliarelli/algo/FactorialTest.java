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
public class FactorialTest {
	@Test
	public void compareFactorials() {
		
		for(int i= 0; i<11; i++) {
			Assert.assertEquals(Factorial.factorial(i), Factorial.iterativeFactorial(i));
		}
	}
}
