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
public class FibonacciTest {
	@Test
	public void comparIterativeFibonacci() {
		for(int i= 0; i<25; i++) {
			int actual = Fibonacci.fibonacci(i);
			Assert.assertEquals(actual, Fibonacci.iterativeFibonacci(i));
			Assert.assertEquals(actual, Fibonacci.naiveIterativeFibonacci(i));
			Assert.assertEquals(actual, Fibonacci.iterativeGGFibonacci(i));
		}
	}
}
