/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import ar.com.magliarelli.structs.BinaryTree;

/**
 * @author lucas
 *
 */
public class BinaryTreeFunctions {
	public static List<Integer> inorder(BinaryTree<Integer> a) {
		List<Integer> s = new LinkedList<Integer>();
		if (!a.isNil()) {
			s.addAll(inorder(a.left()));
			s.add(a.root());
			s.addAll(inorder(a.right()));
		}
		return s;
	}
	public static BinaryTree<Integer> copy(BinaryTree<Integer> a){
		BinaryTree<Integer> c= BinaryTree.nil();
		if(!a.isNil()) {
			c= BinaryTree.bin(copy(a.left()), a.root(), copy(a.right()));
		}
		return c;
	}
	
	public static List<Integer> iterativeInorder(BinaryTree<Integer > a){
		List<Integer> t= new LinkedList<Integer>();
		Stack<InOrderStackPair> p= new Stack<InOrderStackPair>();
		InOrderStackPair q= new InOrderStackPair();
		q.a= a;
		q.s= new LinkedList<Integer>();
		p.push(q);
		while(!p.isEmpty()) {
			InOrderStackPair r= p.pop();
			if(r.a.isNil()) {
				List<Integer> newT= new LinkedList<Integer>(r.s);
				newT.addAll(t);
				t= newT;
			}else {
				BinaryTree<Integer> tmp= r.a;
				r.a= tmp.left();
				p.push(r);
				InOrderStackPair newR= new InOrderStackPair();
				newR.a= tmp.right();
				newR.s= new LinkedList<Integer>();
				newR.s.add(tmp.root());
				p.push(newR);
			}
		}
		return t;
	}
	
	private static class InOrderStackPair{
		public BinaryTree<Integer> a;
		public List<Integer> s;
	}
}
