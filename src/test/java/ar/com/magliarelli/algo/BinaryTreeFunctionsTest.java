/**
 * 
 */
package ar.com.magliarelli.algo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ar.com.magliarelli.structs.BinaryTree;
import org.junit.Assert;

/**
 * @author lucas
 *
 */
@RunWith(JUnit4.class)
public class BinaryTreeFunctionsTest {
	@Test
	public void compareInOrder() {
		BinaryTree<Integer> nil = BinaryTree.nil();
		BinaryTree<Integer> one = BinaryTree.bin(nil, 1, nil);
		BinaryTree<Integer> three = BinaryTree.bin(nil, 3, nil);
		BinaryTree<Integer> two = BinaryTree.bin(one, 2, three);
		Assert.assertEquals(BinaryTreeFunctions.inorder(two), BinaryTreeFunctions.iterativeInorder(two));
	}

	@Test
	public void compareCopy() {
		BinaryTree<Integer> nil = BinaryTree.nil();
		BinaryTree<Integer> one = BinaryTree.bin(nil, 1, nil);
		BinaryTree<Integer> three = BinaryTree.bin(nil, 3, nil);
		BinaryTree<Integer> two = BinaryTree.bin(one, 2, three);
		BinaryTree<Integer> rCopy = BinaryTreeFunctions.copy(two);
		BinaryTree<Integer> iCopy = BinaryTreeFunctions.copy(two);
		assertBinaryTree(two, rCopy);
		assertBinaryTree(rCopy, iCopy);
		Assert.assertEquals(BinaryTreeFunctions.inorder(rCopy), BinaryTreeFunctions.inorder(iCopy));

	}

	private void assertBinaryTree(BinaryTree<Integer> a, BinaryTree<Integer> b) {
		Assert.assertFalse((!a.isNil() && b.isNil()) || ((a.isNil() && !b.isNil())));
		if(!a.isNil() && !b.isNil()) {
			Assert.assertEquals(a.root(), b.root());
			assertBinaryTree(a.left(), b.left());
			assertBinaryTree(a.right(), b.right());
		}

	}
}
