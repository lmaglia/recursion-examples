/**
 * 
 */
package ar.com.magliarelli.algo;

/**
 * @author lucas
 *
 */
public class Factorial {
	public static int factorial(int n) {
		int r= 1;
		if(n>0) {
			r= n * factorial(n-1);
		}
		return r;
	}
	public static int iterativeFactorial(int n) {
		int m=1;
		while(n>0) {
			m= m*n;
			n= n-1;
		}
		return m;
	}
}
