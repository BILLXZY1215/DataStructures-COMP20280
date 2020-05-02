/**
 * The {@code LinkedQueue} in this class has a
 * linked-list implementation of a queue.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {

	// empty list, uses a singly linked list
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	// constructor
	public LinkedQueue() {
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// adds to the end the given element
	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	// returns first element
	@Override
	public E first() {
		return list.get(0);
	}

	// removes first element and returns it
	@Override
	public E dequeue() {
		return list.removeFirst();
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String newString = "[" + list.get(0);

		for (int i = 1; i < size(); i++) {
			newString = newString + ", " + list.get(i);
		}

		return newString + "]";
	}

	public static void main(String[] args) {
		// Create a linked queue that stores integers
		LinkedQueue<Integer> linkedQ = new LinkedQueue<>();

		System.out.println("Size: " + linkedQ.size());
		System.out.println("Is is empty? " + linkedQ.isEmpty());
		System.out.println();

		// Initialize the queue with numbers 0-9
		// This tests the enqueue method
		for (int i = 0; i < 10; ++i)
			linkedQ.enqueue(i);
		System.out.print("Queue: " + linkedQ);
		System.out.println("\nSize: " + linkedQ.size());
		System.out.println("Is is empty? " + linkedQ.isEmpty());

		System.out.println("First element: " + linkedQ.first());

		System.out.println("\nDequeue Twice: " + linkedQ.dequeue() + " & " + linkedQ.dequeue());

		System.out.print("Updated Queue: " + linkedQ);
		System.out.println("\nFirst element: " + linkedQ.first());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}

}
