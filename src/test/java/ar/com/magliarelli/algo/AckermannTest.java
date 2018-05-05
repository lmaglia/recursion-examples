/**
 * 
 */
package ar.com.magliarelli.algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.Assert;
import org.junit.Ignore;

/**
 * @author lucas
 *
 */
@RunWith(JUnit4.class)
public class AckermannTest {
	@Test
	public void compareAckermann() {
		//https://es.wikipedia.org/wiki/Funci%C3%B3n_de_Ackermann
		ar.com.magliarelli.structs.Ackermann ack= new ar.com.magliarelli.structs.Ackermann();
		for(int x= 0; x<4;x++) {
			for(int y= 0; y<5; y++) {
				System.out.println(x+ ", " + y);
				ack.reset();
				int val= Ackermann.ackermann(x, y);
				Assert.assertEquals(val, Ackermann.iterativeAckermann(x, y));
				ack.build(x, y);
				Assert.assertEquals(val, ack.eval());
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
	@Ignore("This throws OOM")
	public void compareAckermannObj() {
		ar.com.magliarelli.structs.Ackermann ack= new ar.com.magliarelli.structs.Ackermann();
		ack.build(4, 1);
		Assert.assertEquals(65533, ack.eval());
	}
}
