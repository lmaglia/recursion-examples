/**
 * 
 */
package ar.com.magliarelli.structs;

/**
 * @author lucas
 *
 */
public class BinaryTree<T> {
	private T root;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	public static <T> BinaryTree<T> bin(BinaryTree<T> left, T root, BinaryTree<T> right){
		return new BinaryTree<T>(left,root,right);
	}
	public static <T> BinaryTree<T> nil(){
		return new NilBinaryTree<T>();
	}
	private BinaryTree() {
		
	}
	private BinaryTree(BinaryTree<T> left, T root, BinaryTree<T> right) {
		this.left= left;
		this.root= root;
		this.right= right;
	}
	public T root() {
		return root;
	}
	public BinaryTree<T> left(){
		return left;
	}
	public BinaryTree<T> right(){
		return right;
	}
	public boolean isNil() {
		return false;
	}
	private static class NilBinaryTree<T> extends BinaryTree<T>{

		@Override
		public boolean isNil() {			
			return true;
		}
		
	}
}
