/**
 * 
 */
package ar.com.magliarelli.structs;

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
	public void fibonacci() {
		Fibonacci fib= new Fibonacci();
		int [] fibs= new int [] {0,1};
		for(int i= 0; i< 6; i++) {
			fib.reset();
			fib.build(i);
			int currentFib= fibs[0] + fibs[1];
			if(i< 2) {
				currentFib= fibs[i];
			}else {
				fibs[0]= fibs[1];
				fibs[1]= currentFib;
			}
			System.out.println(fib);
			Assert.assertEquals(currentFib, fib.fib());
		}
	}
}
