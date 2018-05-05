/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import ar.com.magliarelli.structs.NAryTree;

/**
 * @author lucas
 *
 */
public class NAryTreeFunctions {
	public static NAryTree<Integer> copy(NAryTree<Integer> a) {
		return NAryTree.tree(a.root(), copyChildren(a.children()));
	}

	private static List<NAryTree<Integer>> copyChildren(List<NAryTree<Integer>> children) {
		List<NAryTree<Integer>> cChildren = new LinkedList<NAryTree<Integer>>();
		for (NAryTree<Integer> c : children) {
			cChildren.add(copy(c));
		}
		return cChildren;
	}

	public static NAryTree<Integer> ggCopy(NAryTree<Integer> a) {
		NAryTree<Integer> t = null;
		boolean valid = false;
		Stack<CopyStackItem> p = new Stack<CopyStackItem>();
		while (!p.isEmpty() || !valid) {
			if (!valid) {
				if (a.children().isEmpty()) {
					CopyStackItem x = new CopyStackItem();
					x.x0 = a;
					x.x1 = new LinkedList<NAryTree<Integer>>();
					x.x2 = new LinkedList<NAryTree<Integer>>();
					p.push(x);
					a = null;
					t = null;
					valid = true;
				} else {
					List<NAryTree<Integer>> tailChildren = new LinkedList<NAryTree<Integer>>(a.children());
					NAryTree<Integer> first = tailChildren.remove(0);
					CopyStackItem x = new CopyStackItem();
					x.x0 = a;
					x.x1 = tailChildren;
					x.x2 = new LinkedList<NAryTree<Integer>>();
					p.push(x);
					a = first;
					valid = false;
				}
			} else {
				CopyStackItem top = p.pop();
				if (top.x1.isEmpty()) {
					if(t == null) {
						a= null;						
						t= NAryTree.tree(top.x0.root(), top.x2);
						valid= true;
					}else {
						a= null;						
						top.x2.add(t);
						t= NAryTree.tree(top.x0.root(), top.x2);
						valid= true;
					}
				} else {
					NAryTree<Integer> first= top.x1.remove(0);
					top.x2.add(t);
					a= first;
					t= null;
					valid = false;
					p.push(top);
				}
			}
		}
		return t;
	}

	private static class CopyStackItem {
		public NAryTree<Integer> x0;;
		public List<NAryTree<Integer>> x1;
		public List<NAryTree<Integer>> x2;
	}
}
