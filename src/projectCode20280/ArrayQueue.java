package projectCode20280;

public class ArrayQueue<E> implements Queue<E> {
	
	private static final int CAPACITY = 10;	//default capacity if user doesn't provide one during queue creation
	//instance variables
	private int size = 0;
	private int firstElement = 0;
	private E[] data;
	
	//constructors
	public ArrayQueue() {this(CAPACITY);}	//constructs queue with default capacity if no capacity passed to the object
	
	public ArrayQueue(int capacity) {
		data = (E[]) new Object[capacity];
	}

	//methods
	@Override
	public int size() {return size;}

	@Override
	public boolean isEmpty() {return size==0;}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		if (size == data.length) {
			throw new IllegalStateException("Queue is full");
		}
		int avail = (firstElement + size)% data.length;
		data[avail] = e;
		size++;
	}

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
		firstElement = (firstElement + 1)%data.length;
		size--;
		return answer;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
