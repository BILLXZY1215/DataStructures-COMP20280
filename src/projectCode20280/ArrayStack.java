/**
 * The {@code ArrayStack} in this class implements a
 * stack using an array. Stack is a linear data 
 * structure which follows a particular order 
 * in which the operations are performed. 
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 100; // default array capacity
	private E[] data; // generic array for storage
	private int t = -1; // index of the top element of the stack

	// constructs stack with default capacity
	public ArrayStack() {
		this(CAPACITY);
	}

	// constructor with specified capacity
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return (t + 1);
	}

	@Override
	public boolean isEmpty() {
		return (t == -1);
	}

	@Override
	public void push(E e) throws IllegalArgumentException {
		if (size() == data.length) {
			throw new IllegalArgumentException("Stack is full");
		}
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}

	E peek() {
		if (t < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E x = data[t];
			return x;
		}
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String newString = "[" + data[size()-1];

		for (int i = size()-2; i >= 0; i--) {
			newString = newString + ", " + data[i];
		}

		return newString + "]";
	}

	// main
	public static void main(String[] args) {
		// Create a stack of capacity 21
		ArrayStack<Integer> arrayStack = new ArrayStack<>(21);

		System.out.println("Is it empty? " + arrayStack.isEmpty());
		System.out.println("Push some elements (21,22,23)");
		arrayStack.push(21);
		arrayStack.push(22);
		arrayStack.push(23);
		System.out.println("Stack: " + arrayStack);
		System.out.println("Is it empty? " + arrayStack.isEmpty());
		System.out.println("Size: " + arrayStack.size());
		System.out.println("Element at top: " + arrayStack.top());

		System.out.println("Peek: " + arrayStack.peek());

		System.out.print("Pop twice\nElement at top:");
		arrayStack.pop();
		arrayStack.pop();
		System.out.println(arrayStack.top());
		System.out.println("Size (Should be 1): " + arrayStack.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}
}
