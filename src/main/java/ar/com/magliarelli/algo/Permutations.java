/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author lucas
 *
 */
public class Permutations {
	public static <T> List<T[]> iterativePermutations(T[] a, int i){
		List<T []> perms= new LinkedList<T[]>();
		if (i>= a.length) {
			perms.add(a.clone());
		}else {
			Stack<Tuple<T>> p = new Stack<Tuple<T>>();
			Tuple<T> t= new Tuple<T>();
			t.a= a;
			t.i= i;
			t.j= i;
			p.push(t);
			perms= iterativeGGPermute(perms, a.length, p);
		}
		return perms;
	}
	
	private static <T> List<T[]> iterativeGGPermute(List<T[]> s, int n, Stack<Tuple<T>> p){
		while(!p.isEmpty()) {
			Tuple<T> t= p.pop();
			if(t.j< n) {
				if(t.i+1>=n) {
					T [] aClone= t.a.clone();
					s.add(swap(aClone, t.i,t.j));
					t.j++;
					p.push(t);
				}else {
					Tuple<T> newT= new Tuple<T>();
					newT.a= swap(t.a.clone(), t.i,t.j);
					newT.i= t.i+1;
					newT.j= t.i+1;
					t.j= t.j+1;
					p.push(t);
					p.push(newT);
				}
			}
		}
		return s;
	}
	public static <T> List<T[]> permutations(T[] a, int i) {
		List<T[]> perms = null;
		if (i >= a.length) {
			perms = new LinkedList<T[]>();
			perms.add(a.clone());
		} else {
			perms = permute(a, i, i);
		}
		return perms;
	}

	private static <T> List<T[]> permute(T[] a, int i, int j) {
		List<T[]> perms = new LinkedList<T[]>();
		if (j < a.length) {
			perms = permutations(swap(a, i, j), i + 1);
			// To avoid copying the array multiple times, we restore it by re-swapping its
			// elements.
			perms.addAll(permute(swap(a, i, j), i, j + 1));
		}
		return perms;
	}

	private static <T> T[] swap(T[] a, int i, int j) {
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		return a;
	}
	
	private static class Tuple<T>{
		public T [] a;
		public int i;
		public int j;
	}
}
