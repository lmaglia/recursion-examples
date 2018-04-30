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
public class AckermannTest {
	@Test
	public void compareAckermann() {
		//https://es.wikipedia.org/wiki/Funci%C3%B3n_de_Ackermann
		for(int x= 0; x<4;x++) {
			for(int y= 0; y<5; y++) {
				System.out.println(x+ ", " + y);
				Assert.assertEquals(Ackermann.ackermann(x, y), Ackermann.iterativeAckermann(x, y)); 
			}
		}
		Assert.assertEquals(Ackermann.ackermann(4, 0), Ackermann.iterativeAckermann(4, 0));
		//x = 4 and y = 1 and x = 5 and y = 0 make recursive ackermann throw StackOverflowError
		/*Assert.assertEquals(Ackermann.ackermann(4, 1), Ackermann.iterativeAckermann(4, 1));
		Assert.assertEquals(Ackermann.ackermann(5, 0), Ackermann.iterativeAckermann(5, 0));*/
		Assert.assertEquals(65533, Ackermann.iterativeAckermann(4, 1));
		Assert.assertEquals(65533, Ackermann.iterativeAckermann(5, 0));
		//The iterative ones worked, but it took about 5:30 minutes to complete. 
	}
}
