/**
 * 
 */
package ar.com.magliarelli.structs;

import java.util.List;

/**
 * @author lucas
 *
 */
public class NAryTree<T> {
	private T root;
	private List<NAryTree<T>> children;
	public static <T> NAryTree<T> tree(T root, List<NAryTree<T>> children){
		return new NAryTree<T>(root, children);
	}
	private NAryTree(T root, List<NAryTree<T>> children) {
		this.root= root;
		this.children= children;
	}
	public T root() {
		return root;
	}
	public List<NAryTree<T>> children(){
		return children;
	}
	
}
