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
		int fib = n;
		if (n > 1) {
			fib = fibonacci(n - 1) + fibonacci(n - 2);
		}
		return fib;
	}

	public static int iterativeFibonacci(int n) {
		int m = 0;
		Stack<Integer> p = new Stack<Integer>();
		p.push(n);
		while (!p.isEmpty()) {
			int t = p.pop();
			if (t != 0) {
				if (t == 1) {
					m = m + 1;
				} else {
					p.push(t - 2);
					p.push(t - 1);
				}
			}
		}
		return m;
	}

	public static int naiveIterativeFibonacci(int n) {
		int a = 0;
		int b = 1;
		if (n == 0) {
			b = 0;
		} else {
			int temp = 0;
			while (n > 1) {
				temp = b;
				b = a + b;
				a = temp;
				n = n - 1;
			}
		}
		return b;
	}
	public static int iterativeGGFibonacci(int n) {
		FiboPair t= new FiboPair();
		t.t0= 0;
		t.t1= 0;
		FiboStackPair q= new FiboStackPair();
		q.n= n;
		q.action= Action.PROCESS;
		Stack<FiboStackPair> p= new Stack<FiboStackPair>();
		p.push(q);
		while(!p.isEmpty()) {
			q= p.pop();
			if(!q.action.equals(Action.DONE)) {
				if(q.action.equals(Action.BUILD)) {
					int tmp= t.t0;
					t.t0= t.t0 + t.t1;
					t.t1= tmp;
				}else {
					if(q.n + 1 == 1) {
						t.t0= 1;
						t.t1= 0;
					}else {
						q.action= Action.BUILD;
						p.push(q);
						FiboStackPair processNext= new FiboStackPair();
						processNext.action= Action.PROCESS;
						processNext.n= q.n -1;
						p.push(processNext);
					}
				}
			}
		}
		return t.t1;
	}
	private enum Action {
		PROCESS, BUILD, DONE
	}
	private static class FiboPair{
		public int t0;
		public int t1;		
	}
	private static class FiboStackPair{
		public int n;
		public Action action;
	}
}
