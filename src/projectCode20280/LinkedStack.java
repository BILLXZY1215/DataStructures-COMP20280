/**
 * The {@code LinkedStack} in this class has a
 * linked-list implementation of a stack.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

public class LinkedStack<E> implements Stack<E> {

	// empty list, uses a singly linked list
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();

	// constructor
	public LinkedStack() {
	};

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// adds first element to the start of the list
	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	// returns the first element of the list
	@Override
	public E top() {
		return list.get(0);
	}

	// removes the first element of the list
	@Override
	public E pop() {
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

	// main
	public static void main(String[] args) {

		// Create a linked stack that stores integers
		LinkedStack<Integer> linkedSt = new LinkedStack<>();

		System.out.println("Size: " + linkedSt.size());
		System.out.println("Is is empty? " + linkedSt.isEmpty());
		System.out.println();

		System.out.println("Push some elements onto the stack (3,4,5,6)");
		linkedSt.push(3);
		linkedSt.push(4);
		linkedSt.push(5);
		linkedSt.push(6);
		System.out.println("Stack: " + linkedSt);
		System.out.println("Size: " + linkedSt.size());
		System.out.println("Is is empty? " + linkedSt.isEmpty());
		System.out.println("Top element of the stack:" + linkedSt.top());

		System.out.println("\nPop two elements from the stack");
		linkedSt.pop();
		linkedSt.pop();
		System.out.println("Stack: " + linkedSt);
		System.out.println("Size: " + linkedSt.size());
		System.out.println("Top element of the stack:" + linkedSt.top());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}

}
