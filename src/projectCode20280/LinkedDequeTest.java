/**
 * The {@code LinkedDequeTest} in this class implements a
 * junit test for a linked dequeue class.
 *
 * @author Ahmed Jouda
 */
package projectCode20280;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedDequeTest {

	@Test
	void testSize() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addFirst(i);
		assertEquals(10, s.size());
	}

	@Test
	void testIsEmpty() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addFirst(i);
		for (int i = 0; i < 10; ++i)
			s.removeLast();
		assertEquals(true, s.isEmpty());
	}

	@Test
	void testbackEnqueue() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addLast(i);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", s.toString());
	}
	
	@Test
	void testfrontEnqueue() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addFirst(i);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", s.toString());
	}

	@Test
	void testFirst() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addLast(i);
		assertEquals(0, s.first());
	}
	
	@Test
	void testLast() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 0; i < 10; ++i)
			s.addLast(i);
		assertEquals(9, s.last());
	}

	@Test
	void testfrontDeque() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 10; i < 20; ++i)
			s.addLast(i);

		assertEquals(10, s.removeFirst());
		assertEquals(9, s.size());
	}
	
	@Test
	void testbackDeque() {
		LinkedDeque<Integer> s = new LinkedDeque<>();
		for (int i = 10; i < 20; ++i)
			s.addLast(i);

		assertEquals(19, s.removeLast());
		assertEquals(9, s.size());
	}

}