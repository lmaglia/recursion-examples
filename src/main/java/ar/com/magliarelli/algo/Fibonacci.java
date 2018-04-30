/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.Stack;

/**
 * @author lucas
 *
 */
public class Fibonacci {
	public static int fibonacci(int n) {
		int fib= n;
		if (n > 1) {
			fib = fibonacci(n-1) + fibonacci(n-2);
		} 
		return fib;
	}
	public static int iterativeFibonacci(int n) {
		int m= 0;
		Stack<Integer> p = new Stack<Integer>();
		p.push(n);
		while(!p.isEmpty()) {
			int t= p.pop();
			if (t!=0) {
				if (t == 1) {
					m= m+1;
				}else {
					p.push(t-2);
					p.push(t-1);
				}
			}
		}
		return m;
	}
	public static int naiveIterativeFibonacci(int n) {
		int a= 0;
		int b= 1;
		if(n== 0) {
			b= 0;
		}else {
			int temp= 0;
			while(n>1) {
				temp= b;
				b= a+b;
				a= temp;
				n= n-1;
			}
		}
		return b;
	}
}
