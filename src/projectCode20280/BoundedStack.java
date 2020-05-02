/**
 * The {@code BoundedStack} in this class is an 
 * implementation of a stack using a fixed, 
 * non-expandable array whose capacity is 
 * set in its constructor.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class BoundedStack<E> {

	// default capacity
	public static final int DEFAULT_BOUND = 32;

	private final E[] elements;
	private int t = -1;

	public BoundedStack() {
		this(DEFAULT_BOUND);
	}

	@SuppressWarnings("unchecked")
	public BoundedStack(int bound) {
		elements = (E[]) new Object[bound];
	}

	public int getSize() {
		return t + 1;
	}

	public int getBound() {
		return elements.length;
	}

	public boolean isEmpty() {
		return t == -1;
	}

	public void push(E e) throws IllegalArgumentException {
		if (getSize() == elements.length) {
			throw new IllegalArgumentException("Stack is full");
		}
		elements[++t] = e;
	}

	public E top() {
		if (isEmpty()) {
			return null;
		}
		return elements[t];
	}

	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = elements[t];
		elements[t] = null;
		t--;
		return answer;
	}

	E peek() {
		if (t < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E x = elements[t];
			return x;
		}
	}

	// main
	public static void main(String[] args) {
		// Create a bounded stack of default capacity
		BoundedStack<Integer> bStack = new BoundedStack<>(3);

		System.out.println("Is it empty? " + bStack.isEmpty());
		System.out.println("Push some elements (21,22,23)");
		bStack.push(21);
		bStack.push(22);
		bStack.push(23);
		System.out.println("Is it empty? " + bStack.isEmpty());
		System.out.println("Size: " + bStack.getSize());
		System.out.println("Element at top: " + bStack.top());

		System.out.println("Peek: " + bStack.peek());

		System.out.print("Pop twice\nElement at top:");
		bStack.pop();
		bStack.pop();
		System.out.println(bStack.top());
		System.out.println("Size (Should be 1): " + bStack.getSize());

		System.out.println("\n***PASSED ALL TESTS***");
	}
}
