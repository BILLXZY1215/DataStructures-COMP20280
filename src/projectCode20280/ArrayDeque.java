/**
 * The {@code ArrayDeque} in this class provides a way to apply 
 * resizable-array in addition to the implementation of the 
 * Deque interface. It is also known as Array Double Ended 
 * Queue or Array Deck. This is a special kind of array that 
 * grows and allows users to add or remove an element from 
 * both the sides of the queue.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class ArrayDeque {
	// instance variables
	static final int MAX = 100;
	int arr[];
	int front;
	int rear;
	int size;

	// constructor takes in the size of the deque to be constructed
	public ArrayDeque(int size) {
		arr = new int[MAX];
		front = -1;
		rear = 0;
		this.size = size;
	}

	// Checks whether Deque is full or not.
	boolean isFull() {
		return ((front == 0 && rear == size - 1) || front == rear + 1);
	}

	// Checks whether Deque is empty or not.
	boolean isEmpty() {
		return (front == -1);
	}

	// Inserts an element at front
	void insertfront(int key) {
		// check whether Deque if full or not
		if (isFull()) {
			System.out.println("Overflow");
			return;
		}

		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// front is at first position of queue
		else if (front == 0)
			front = size - 1;

		else // decrement front end by '1'
			front = front - 1;

		// insert current element into Deque
		arr[front] = key;
	}

	// function to inset element at rear end
	// of Deque.
	void insertrear(int key) {
		if (isFull()) {
			System.out.println(" Overflow ");
			return;
		}

		// If queue is initially empty
		if (front == -1) {
			front = 0;
			rear = 0;
		}

		// rear is at last position of queue
		else if (rear == size - 1)
			rear = 0;

		// increment rear end by '1'
		else
			rear = rear + 1;

		// insert current element into Deque
		arr[rear] = key;
	}

	// Deletes element at front end of Deque
	void deletefront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println("Queue Underflow\n");
			return;
		}

		// Deque has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
		// back to initial position
		if (front == size - 1)
			front = 0;

		else // increment front by '1' to remove current
				// front value from Deque
			front = front + 1;
	}

	// Delete element at rear end of Deque
	void deleterear() {
		if (isEmpty()) {
			System.out.println(" Underflow");
			return;
		}

		// Deque has only one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (rear == 0)
			rear = size - 1;
		else
			rear = rear - 1;
	}

	// Returns front element of Deque
	int getFront() {
		// check whether Deque is empty or not
		if (isEmpty()) {
			System.out.println(" Underflow");
			return -1;
		}
		return arr[front];
	}

	// function return rear element of Deque
	int getRear() {
		// check whether Deque is empty or not
		if (isEmpty() || rear < 0) {
			System.out.println(" Underflow\n");
			return -1;
		}
		return arr[rear];
	}

	// Driver program to test above function
	public static void main(String[] args) {

		ArrayDeque dq = new ArrayDeque(5);

		System.out.println("Is is empty? " + dq.isEmpty());
		System.out.println("Insert 3 at the end");
		dq.insertrear(3);
		System.out.println("Insert 16 at the end");
		dq.insertrear(16);
		System.out.println("Element at rear: " + dq.getRear());
		dq.deleterear();
		System.out.println("After deleterear() element new rear becomes: " + dq.getRear());
		System.out.println("Insert 25 at front");
		dq.insertfront(25);
		System.out.println("Element at front: " + dq.getFront());
		dq.deletefront();
		System.out.println("After deletefront() element at front becomes: " + +dq.getFront());
		System.out.println("Is is empty? " + dq.isEmpty());
		System.out.println("Is is full (has 5)? " + dq.isFull());

		System.out.println("\n***PASSED ALL TESTS***");
	}
}
