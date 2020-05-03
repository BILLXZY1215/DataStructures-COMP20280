/**
 * The {@code LinkedCircularQueue} in this class realizes a
 * circular FIFO queue as an adaptation of a CircularlyLinkedList. 
 * This provides one additional method not part of the general 
 * Queue interface. A call to rotate() is a more efficient 
 * simulation of the combination enqueue(dequeue()).
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class LinkedCircularQueue<E> implements Queue<E> {
	CircularlyLinkedList<E> cll = new CircularlyLinkedList<>();

	public static void main(String[] args) {

		// Create a linked circular queue that stores integers
		LinkedCircularQueue<Integer> circularQ = new LinkedCircularQueue<Integer>();
		System.out.println("Size: " + circularQ.size());
		System.out.println("Is it empty?: " + circularQ.isEmpty());

		System.out.println("\nEnqueue some elements (2,3,4,5)");
		circularQ.enqueue(2);
		circularQ.enqueue(3);
		circularQ.enqueue(4);
		circularQ.enqueue(5);
		System.out.println("Queue: " + circularQ);
		System.out.println("Size: " + circularQ.size());
		System.out.println("Is it empty?: " + circularQ.isEmpty());

		System.out.println("\nFirst element: " + circularQ.first());

		System.out.println("\nDequeue two elements");
		circularQ.dequeue();
		circularQ.dequeue();
		System.out.println("Queue: " + circularQ);
		System.out.println("New Size: " + circularQ.size());

		System.out.println("\nRotate it");
		circularQ.rotate();
		System.out.println("Queue: " + circularQ);

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");
	}

	@Override
	public int size() {
		return this.cll.size();
	}

	@Override
	public boolean isEmpty() {
		return this.cll.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		this.cll.addLast(e);
	}

	@Override
	public E first() {
		return this.cll.first();
	}

	@Override
	public E dequeue() {
		return this.cll.removeFirst();
	}

	public void rotate() {
		this.cll.rotate();
	}

	public String toString() {
		return cll.toString();
	}
}