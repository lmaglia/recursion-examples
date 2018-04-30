/**
 * 
 */
package ar.com.magliarelli.algo;

/**
 * @author lucas
 *
 */
public class GCD {
	public static int gcd(int a, int b) {
		int r= a;
		if (b > 0) {
			r= gcd(b, a % b);
		}
		return r;
	}
	public static int iterativeGCD(int a, int b) {
		int r= a;
		while(b>0) {
			r= b;			
			b= a % b;
			a= r;
		}
		return r;
	}
}
