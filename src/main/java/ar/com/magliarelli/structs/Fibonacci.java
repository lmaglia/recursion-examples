/**
 * 
 */
package ar.com.magliarelli.structs;

/**
 * @author lucas
 *
 */
public class Fibonacci {
	private int n;
	private int fib;
	private Fibonacci nMinus1;
	private Fibonacci nMinus2;
	public Fibonacci build(int n) {
		this.n= n;
		if (n > 1) {
			this.fib= -1;
			this.nMinus1= new Fibonacci();
			this.nMinus1.build(n-1);
			this.nMinus2= new Fibonacci();
			this.nMinus2.build(n-2);
		}else {
			this.fib= n;
			this.nMinus1= null;
			this.nMinus2= null;
		}
		return this;
	}
	public int fib() {
		if(this.fib == -1) {
			this.fib = this.nMinus1.fib() + this.nMinus2.fib();
		}
		return this.fib;
	}
	public int getN() {
		return this.n;
	}
	public void reset() {
		this.fib= -1;
		this.n= -1;
		this.nMinus1= null;
		this.nMinus2= null;
	}
	public String toString() {
		StringBuffer buffer= new StringBuffer();
		if(this.n < 2) {
			buffer.append(" ").append(this.n).append(" ");
		}else {
			buffer.append(" ").append(this.n).append(" ").append(this.nMinus2.toString()).append(" ");
			buffer.append(this.nMinus1.toString()).append(" ");
		}
		return buffer.toString();
	}
}
