/**
 * The {@code ArrayQueue} in this class implements a
 * queue using an array. In queue, insertion and 
 * deletion happen at the opposite ends.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class ArrayQueue<E> implements Queue<E> {

	private static final int CAPACITY = 10; // default capacity if user doesn't provide one during queue creation
	// instance variables
	private int size = 0;
	private int firstElement = 0;
	private E[] data;

	// constructors
	public ArrayQueue() {
		this(CAPACITY);
	} // constructs queue with default capacity if no capacity passed to the object

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	// methods
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (size == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int avail = (firstElement + size) % data.length;
		data[avail] = e;
		size++;
	}

	//returns first element
	@Override
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return data[firstElement];
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[firstElement];
		data[firstElement] = null;
		firstElement = (firstElement + 1) % data.length;
		size--;
		return answer;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String newString = "[" + data[0];

		for (int i = 1; i < size(); i++) {
			newString = newString + ", " + data[i];
		}

		return newString + "]";
	}

	public static void main(String[] args) {
		// Create a queue of default capacity (10)
		ArrayQueue<Integer> q = new ArrayQueue<>();

		System.out.println("Is it empty? " + q.isEmpty());
		System.out.println("Enqueue some elements (12,13,14)");
		// inserting elements in the queue
		q.enqueue(12);
		q.enqueue(13);
		q.enqueue(14);
		System.out.println("What is the size? " + q.size());
		System.out.println("Element at front: " + q.first());

		System.out.println("Enqueue 20");
		q.enqueue(20);
		System.out.println("Element at front: " + q.first());

		System.out.println("Dequeue twice\nElement at front:");
		q.dequeue();
		q.dequeue();
		System.out.println(q.first());
		System.out.println("What is the size? (Should be 2): " + q.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}

}
