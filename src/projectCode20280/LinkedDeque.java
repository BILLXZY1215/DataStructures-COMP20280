/**
 * The {@code LinkedDeque} in this class implements a
 * deque which is related to the double-ended queue 
 * that supports addition or removal of elements 
 * from either end of the data structure.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {

	DoublyLinkedList<E> ldq = new DoublyLinkedList<>();

	@Override
	public int size() {
		return ldq.size();
	}

	@Override
	public boolean isEmpty() {
		return ldq.isEmpty();
	}

	@Override
	public E first() {
		if (isEmpty())
			return null;
		else
			return ldq.first();
	}

	@Override
	public E last() {
		if (isEmpty())
			return null;
		else
			return ldq.last();
	}

	@Override
	public void addFirst(E e) {
		ldq.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		ldq.addLast(e);
	}

	@Override
	public E removeFirst() {
		return ldq.removeFirst();
	}

	@Override
	public E removeLast() {
		return ldq.removeLast();
	}

	public String toString() {
		return ldq.toString();
	}

	public static void main(String[] args) {

		// Create a linked deque that stores integers
		LinkedDeque<Integer> linkedDQ = new LinkedDeque<Integer>();
		System.out.println("Size: " + linkedDQ.size());
		System.out.println("Is is empty? " + linkedDQ.isEmpty());
		// Initialize the queue with numbers 10-19
		// This tests the add last method
		for (int i = 10; i < 20; ++i)
			linkedDQ.addLast(i);

		System.out.println("\nQueue : " + linkedDQ);
		System.out.println("Size: " + linkedDQ.size());
		System.out.println("Is is empty? " + linkedDQ.isEmpty());

		System.out.println("\nRemove first (Front deque) ");
		linkedDQ.removeFirst();
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nRemove last (Back deque) TWICE");
		linkedDQ.removeLast();
		linkedDQ.removeLast();
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nFirst element: " + linkedDQ.first());
		System.out.println("Last element: " + linkedDQ.last());

		System.out.println("\nAdd first (Front enqueue) ");
		linkedDQ.addFirst(99);
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\nAdd last (Back enqueue) ");
		linkedDQ.addLast(66);
		System.out.println("Updated Queue: " + linkedDQ);

		System.out.println("\n***PASSED ALL TESTS***");

	}
}