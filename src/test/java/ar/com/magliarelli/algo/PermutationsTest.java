/**
 * 
 */
package ar.com.magliarelli.algo;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.junit.Assert;

/**
 * @author lucas
 *
 */
@RunWith(JUnit4.class)
public class PermutationsTest {
	@Test
	public void oneElementRecursivePermutations() {
		Integer[] a = new Integer[] { 1 };
		List<Integer[]> expected = new LinkedList<Integer[]>();
		expected.add(a);
		List<Integer[]> perms = Permutations.permutations(a, 0);
		assertPermutations(expected, perms);
	}

	@Test
	public void twoElementRecursivePermutations() {
		Integer[] a = new Integer[] { 1, 2 };
		List<Integer[]> expected = new LinkedList<Integer[]>();
		expected.add(a);
		expected.add(new Integer[] { 2, 1 });
		List<Integer[]> perms = Permutations.permutations(a, 0);
		assertPermutations(expected, perms);
	}

	@Test
	public void threeElementRecursivePermutations() {
		Integer[] a = new Integer[] { 1, 2, 3 };
		List<Integer[]> expected = new LinkedList<Integer[]>();
		expected.add(a);
		expected.add(new Integer[] { 1, 3, 2 });
		expected.add(new Integer[] { 2, 1, 3 });
		expected.add(new Integer[] { 2, 3, 1 });
		expected.add(new Integer[] { 3, 2, 1 });
		expected.add(new Integer[] { 3, 1, 2 });
		List<Integer[]> perms = Permutations.permutations(a, 0);
		assertPermutations(expected, perms);
	}

	@Test
	public void iterativePermutations() {
		for (int i = 1; i < 11; i++) {
			Integer[] a = (Integer[]) IntStream.rangeClosed(1, i).boxed().toArray((x) -> new Integer[x]);
			List<Integer[]> expected = Permutations.permutations(a, 0);
			List<Integer[]> actual = Permutations.iterativePermutations(a, 0);
			this.assertPermutations(expected, actual);
		}
	}

	private void assertPermutations(List<Integer[]> expected, List<Integer[]> perms) {
		Assert.assertEquals(expected.size(), perms.size());
		Iterator<Integer[]> eIt = expected.iterator();
		Iterator<Integer[]> aIt = perms.iterator();
		while (eIt.hasNext() && aIt.hasNext()) {
			Integer[] exp = eIt.next();
			Integer[] actual = aIt.next();
			Assert.assertArrayEquals(exp, actual);
		}
	}
}
