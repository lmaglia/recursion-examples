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
		BinaryTree<Integer> nil= BinaryTree.nil();
		BinaryTree<Integer> one= BinaryTree.bin(nil, 1, nil);		
		BinaryTree<Integer> three= BinaryTree.bin(nil, 3, nil);
		BinaryTree<Integer> two= BinaryTree.bin(one, 2, three);
		Assert.assertEquals(BinaryTreeFunctions.inorder(two), BinaryTreeFunctions.iterativeInorder(two));
	}
}
