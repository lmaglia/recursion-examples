/**
 * 
 */
package ar.com.magliarelli.structs;

/**
 * @author lucas
 *
 */
public class Ackermann {
	private int x;
	private int y;
	private int eval;
	private Ackermann xMinus11;
	private Ackermann xyMinus1;
	private Ackermann xMinus1Ack;
	
	public Ackermann() {
		this.eval= -1;
	}
	public void build(int x, int y) {
		this.x= x;
		this.y= y;
		if(x != 0 ) {
			if (y == 0) {
				this.xMinus11= new Ackermann();
				this.xMinus11.build(x-1, 1);
			}else {
				this.xyMinus1= new Ackermann();
				this.xyMinus1.build(x, y-1);
				this.xMinus1Ack= new Ackermann();
				this.xMinus1Ack.build(x-1, this.xyMinus1.eval());
			}
		}
	}
	public int eval() {
		if(this.eval == -1) {
			if (x == 0) {
				this.eval= y+1;
			}else {
				if (y == 0) {
					this.eval= this.xMinus11.eval();
				}else {
					this.eval= this.xMinus1Ack.eval();
				}
			}
		}
		return eval;
	}
	public void reset() {
		this.eval= -1;		
	}
}
