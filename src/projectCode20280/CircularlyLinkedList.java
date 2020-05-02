/**
 * The {@code CircularlyLinkedList} in this class implements a
 * fully functioning circular linked list. It supports all of 
 * the public behaviors of our SinglyLinkedList class and one 
 * additional update method rotate().
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {

	private static class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n) {

			element = e;
			next = n;
		}

		// accessors
		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		// modifier
		public void setNext(Node<E> n) {
			next = n;
		}

	}

	private Node<E> tail = null;
	private int size = 0;

	// constructor
	public CircularlyLinkedList() {
	}

	// access methods
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// returns first element
	public E first() {
		if (isEmpty())
			return null;
		return tail.getNext().getElement();
	}

	// returns last element
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement();
	}

	// returns element at given position
	@Override
	public E get(int i) {
		if (isEmpty()) {
			return null;
		}
		Node<E> curr = tail.getNext();
		for (int j = 0; j < i; j++) {

			curr = curr.getNext();
		}

		return curr.getElement();
	}

	// update methods

	// adds given element at given position
	@Override
	public void add(int i, E e) {
		Node<E> newNode = new Node<E>(e, null);
		Node<E> prevNode = tail;
		Node<E> currNode = tail.getNext();

		for (int j = 0; j < i; j++) {
			prevNode = currNode;
			currNode = currNode.next;
		}

		prevNode.setNext(newNode);
		newNode.setNext(currNode);

		size++;

	}

	// removes specified element and returns it
	@Override
	public E remove(int i) {
		if (isEmpty()) {
			throw new RuntimeException("cant delete");
		}
		Node<E> headNode = tail.getNext();
		Node<E> cur = headNode;
		Node<E> prev = null;
		if (i == 0) {
			tail.setNext(headNode.getNext());
			size--;
			return headNode.getElement();
		} else if (i == size - 1) {
			System.out.print(removeLast());
			return null;
		} else {

			for (int j = 0; j < i; j++) {
				prev = cur;
				cur = cur.getNext();
			}

			prev.next = cur.next;
			size--;
		}
		return cur.getElement();
	}

	// removes first element and returns it
	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Node<E> head = tail.getNext();

		if (head == tail) {
			tail = null;
		} else {
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}

	// removes last element and returns it
	@Override
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		Node<E> last = tail;
		Node<E> secLast = tail.getNext();
		Node<E> headNode = tail.getNext();
		if (secLast == tail) {
			tail = null;
		} else {
			while (secLast.getNext() != tail) {
				secLast = secLast.getNext();
			}
			tail = secLast;
			tail.setNext(headNode);
		}

		size--;
		return last.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		Node<E> cu = tail.getNext();

		for (int i = 0; i < size; i++) {

			System.out.print(cu.getElement() + " ");
			cu = cu.next;

		}
		return null;
	}

	// adds given element to the start of the list
	@Override
	public void addFirst(E e) {
		if (size == 0) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}

	// adds given element to the end of the list
	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();

	}

	// rotates the list, first becomes last and all elements moved one space
	public void rotate() {
		if (tail != null) {
			tail = tail.getNext();
		}
	}

	@Override
	public String toString() {
		String newString = "[ ";

		Node<E> current = tail.getNext();
		while (current != tail) {
			newString = newString + current.getElement();
			newString = newString + "->";

			if (current.getNext() == tail) {
				newString = newString + tail.getElement() + " ]";
			}

			current = current.getNext();
		}

		return newString;
	}

	public static void main(String[] args) {

		// Create a circularly linked list that contains integers
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		System.out.println("Is it empty? " + ll.isEmpty());
		// fill it with values from 10 till and including 19
		// this tests the addLast method
		for (int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}
		// display the list
		System.out.println("\nCircular Linked List: " + ll);
		System.out.println("Is it empty? " + ll.isEmpty());

		System.out.println("\nRemoved First Element: " + ll.removeFirst());
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nRemoved Last Element: " + ll.removeLast());
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nRemoved 4th Element: " + ll.remove(4));
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nRotate List ");
		ll.rotate();
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nRemoved First Element & rotate: " + ll.removeFirst());
		ll.rotate();
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nRemoved Last Element & rotate: " + ll.removeLast());
		ll.rotate();
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\nIterate through the list: ");
		ll.iterator();

		System.out.println("\n\nAdd at position 2 number 25: ");
		ll.add(2, 25);
		System.out.println("Updated Circular Linked List: " + ll);

		System.out.println("\n***PASSED ALL TESTS***");

	}
}
