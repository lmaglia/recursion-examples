/**
 * 
 */
package ar.com.magliarelli.algo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import ar.com.magliarelli.structs.NAryTree;
import org.junit.Assert;

/**
 * @author lucas
 *
 */
@RunWith(JUnit4.class)
public class NAryTreeFunctionsTest {
	@Test
	public void compareCopy() {
		NAryTree<Integer> tree= this.createNAryTree();
		NAryTree<Integer> rCopy= NAryTreeFunctions.copy(tree);
		NAryTree<Integer> iCopy= NAryTreeFunctions.ggCopy(tree);
		assertNAryTree(tree, rCopy);
		assertNAryTree(tree, iCopy);
	}

	private void assertNAryTree(NAryTree<Integer> a, NAryTree<Integer> b) {
		Assert.assertEquals(a.root(), b.root());
		Assert.assertEquals(a.children().size(), b.children().size());
		Iterator<NAryTree<Integer>> aIt= a.children().iterator();
		Iterator<NAryTree<Integer>> bIt= b.children().iterator();		
		while(aIt.hasNext() && bIt.hasNext()) {
			NAryTree<Integer> cA= aIt.next();
			NAryTree<Integer> cB= bIt.next();
			this.assertNAryTree(cA, cB);
		}
	}

	private NAryTree<Integer> createNAryTree() {
		NAryTree<Integer> t0= NAryTree.tree(3, new LinkedList<NAryTree<Integer>>());
		NAryTree<Integer> t1= NAryTree.tree(2, new LinkedList<NAryTree<Integer>>());
		NAryTree<Integer> t2= NAryTree.tree(3, new LinkedList<NAryTree<Integer>>());
		NAryTree<Integer> t3= NAryTree.tree(1, new LinkedList<NAryTree<Integer>>());
		NAryTree<Integer> t4= NAryTree.tree(2, new LinkedList<NAryTree<Integer>>());
		NAryTree<Integer> t5= NAryTree.tree(1, new LinkedList<NAryTree<Integer>>());
		
		NAryTree<Integer> x0= NAryTree.tree(2, new LinkedList<NAryTree<Integer>>(Arrays.asList(t0)));
		NAryTree<Integer> x1= NAryTree.tree(3, new LinkedList<NAryTree<Integer>>(Arrays.asList(t1)));
		NAryTree<Integer> x2= NAryTree.tree(1, new LinkedList<NAryTree<Integer>>(Arrays.asList(t2)));
		NAryTree<Integer> x3= NAryTree.tree(3, new LinkedList<NAryTree<Integer>>(Arrays.asList(t3)));
		NAryTree<Integer> x4= NAryTree.tree(1, new LinkedList<NAryTree<Integer>>(Arrays.asList(t4)));
		NAryTree<Integer> x5= NAryTree.tree(2, new LinkedList<NAryTree<Integer>>(Arrays.asList(t5)));
		
		NAryTree<Integer> y0= NAryTree.tree(1, new LinkedList<NAryTree<Integer>>(Arrays.asList(x0,x1)));
		NAryTree<Integer> y1= NAryTree.tree(2, new LinkedList<NAryTree<Integer>>(Arrays.asList(x2,x3)));
		NAryTree<Integer> y2= NAryTree.tree(3, new LinkedList<NAryTree<Integer>>(Arrays.asList(x4,x5)));
		
		NAryTree<Integer> r0= NAryTree.tree(0, new LinkedList<NAryTree<Integer>>(Arrays.asList(y0,y1,y2)));
		
		return r0;
	}
}
