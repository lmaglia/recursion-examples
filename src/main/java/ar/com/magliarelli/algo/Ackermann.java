/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.Stack;

/**
 * @author lucas
 *
 */
public class Ackermann {
	public static int ackermann(int x, int y) {
		int ack= 0;
		if (x == 0) {
			ack= y+1;
		}else {
			if (y == 0) {
				ack= ackermann(x-1, 1);
			}else {
				ack= ackermann(x-1,ackermann(x,y-1));
			}
		}
		return ack;
	}
	public static int iterativeAckermann(int x, int y) {		
		Stack<Integer> p = new Stack<Integer>();
		p.push(x);
		while(!p.isEmpty()) {
			int t= p.pop();
			if (t == 0) {
				y= y+1;
			}else {
				if (y == 0) {
					y= 1;
					p.push(t-1);
				}else {
					y= y-1;
					p.push(t-1);
					p.push(t);
				}
			}
		}
		return y;
	}
}
