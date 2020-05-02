package projectCode20280;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class LinkedCircularQueue<E> implements Queue<E> {
	CircularlyLinkedList<E> l = new CircularlyLinkedList<>();
	
	public static void main(String[] args) {
		LinkedCircularQueue<Integer> cQueue = new LinkedCircularQueue<Integer>();
		System.out.println("Original Size: " + cQueue.size());
		System.out.println("Is it empty?: " + cQueue.isEmpty());
		cQueue.enqueue(2);
		cQueue.enqueue(3);
		cQueue.enqueue(4);
		cQueue.enqueue(5);
		System.out.println(cQueue.l.toString());
		cQueue.dequeue();
		System.out.println(cQueue.l.toString());
		System.out.println("New Size: " + cQueue.size());
	}

	@Override
	public int size() {
		return this.l.size();
	}

	@Override
	public boolean isEmpty() {
		return this.l.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		this.l.addLast(e);
	}

	@Override
	public E first() {
		return this.l.first();
	}

	@Override
	public E dequeue() {
		return this.l.removeFirst();
	}

	public void rotate() {
        this.l.rotate();
    }
	
	public String toString() {
	    return l.toString();
	  }
}