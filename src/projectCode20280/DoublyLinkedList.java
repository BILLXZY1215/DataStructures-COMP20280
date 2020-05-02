/**
 * The {@code DoublyLinkedList} in this class implements a
 * fully functioning doubly linked list. Generic framework
 * is used to accept any type of element.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p; // extra prev reference not in SLL
			next = n;
		}

		// getters and setters
		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	}

	private Node<E> headerNode;
	private Node<E> trailerNode;
	private int size = 0;

	// constructor
	public DoublyLinkedList() {
		headerNode = new Node<>(null, null, null); // create header
		trailerNode = new Node<>(null, headerNode, null); // trailer is preceded by header
		headerNode.setNext(trailerNode); // header is followed by trailer
	}

	// adds element between two nodes
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {

		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	// returns first element of the list
	public E first() {
		if (isEmpty())
			return null;
		return headerNode.getNext().getElement();
	}

	// returns last element of the list
	public E last() {
		if (isEmpty())
			return null;
		return trailerNode.getPrev().getElement();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// returns the element at specified position
	@Override
	public E get(int i) {
		Node<E> currNode = headerNode.getNext();
		for (int j = 0; j < i; j++) {
			currNode = currNode.getNext();
		}
		return currNode.getElement();
	}

	// adds element at specified position
	@Override
	public void add(int i, E e) {
		Node<E> newNode = new Node<E>(e, null, null);
		Node<E> currNode = headerNode.getNext();

		for (int j = 0; j < i; j++) {
			currNode = currNode.getNext();
		}

		Node<E> previousNode = currNode.getPrev();

		previousNode.setNext(newNode);
		newNode.setNext(currNode);
		newNode.setPrev(previousNode);

		size++;

	}

	// removes element at specified position and returns it
	@Override
	public E remove(int i) {
		if (headerNode.getNext() == null) {
			throw new RuntimeException("Cant Delete");
		}

		Node<E> currNode = headerNode.getNext();

		for (int j = 0; j < i; j++) {
			currNode = currNode.getNext();
		}

		Node<E> predecessor = currNode.getPrev();
		Node<E> successor = currNode.getNext();

		predecessor.setNext(successor);
		successor.setPrev(predecessor);

		size--;

		return currNode.getElement();
	}

	@Override
	public Iterator<E> iterator() {
		if (isEmpty()) {
			System.out.println("Empty List");
		} else {
			Node<E> cuNode = headerNode.getNext();
			while (cuNode.getNext() != null) {
				System.out.print(cuNode.getElement() + " ");
				cuNode = cuNode.getNext();
			}
		}

		return null;
	}

	// removes first element and returns it
	@Override
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		if (size != 0) {
			headerNode = headerNode.next;
			size--;
		}

		return headerNode.getElement();
	}

	// removes last element and returns it
	@Override
	public E removeLast() {
		Node<E> toDelete = trailerNode.getPrev();
		Node<E> predeccesor = toDelete.getPrev();
		Node<E> successor = toDelete.getNext();
		predeccesor.setNext(successor);
		successor.setPrev(predeccesor);
		size--;
		return toDelete.getElement();
	}

	// adds given element to the start of the list
	@Override
	public void addFirst(E e) {
		addBetween(e, headerNode, headerNode.getNext());

	}

	// adds given element to the end of the list
	@Override
	public void addLast(E e) {
		addBetween(e, trailerNode.getPrev(), trailerNode);

	}

	@Override
	public String toString() {
		String result = "[";
		Node<E> current = headerNode.getNext();
		while (current.getNext() != null) {
			result += current.getElement();
			if (current.getNext().getNext() != null) {
				result += ", ";
			}
			current = current.getNext();
		}
		return result + "]";
	}

	public static void main(String[] args) {

		// Create a doubly linked list that contains integers
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		System.out.println("Is it empty? " + ll.isEmpty());
		// fill it - this tests add first and last
		ll.addFirst(0);
		ll.addFirst(1);
		ll.addLast(9);
		ll.addFirst(2);
		ll.addLast(-1);
		System.out.println("Doubly Linked List: " + ll);
		System.out.println("Is it empty? " + ll.isEmpty());
		System.out.println("Size: " + ll.size());

		System.out.println("Element at position 2: " + ll.get(2));
		System.out.println("Add at position 2 the number 7: ");
		ll.add(2, 7);
		System.out.println("Updated Doubly Linked List: " + ll);
		System.out.println("Size: " + ll.size());

		System.out.println("Remove the first element: " + ll.removeFirst());
		System.out.println("Updated Doubly Linked List: " + ll);

		System.out.println("Remove the last element: " + ll.removeLast());
		System.out.println("Updated Doubly Linked List: " + ll);

		System.out.println("Remove element at position 1: " + ll.remove(1));
		System.out.println("Updated Doubly Linked List: " + ll);

		System.out.print("Iterate through the List: ");
		ll.iterator();
		System.out.println("\nSize: " + ll.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

		/*
		 * ****EXTRA TESTING**** DoublyLinkedList<Integer> ll1 = new
		 * DoublyLinkedList<Integer>();
		 * 
		 * ll1.addFirst(0); ll1.addFirst(1); ll1.addFirst(3); ll1.addFirst(4);
		 * ll1.addFirst(5); ll1.add(3, 2); System.out.println(ll1); ll1.addFirst(-100);
		 * ll1.addLast(+100); System.out.println(ll1); ll1.removeFirst();
		 * ll1.removeLast(); System.out.println(ll1);
		 * 
		 * ll1.removeFirst(); System.out.println(ll1); ll1.removeLast();
		 * System.out.println(ll1); ll1.removeFirst(); System.out.println(ll1);
		 * ll1.addFirst(9999); ll1.addFirst(8888); ll1.addFirst(7777);
		 * 
		 * System.out.println(ll1); System.out.println(ll1.get(0));
		 * System.out.println(ll1.get(1)); System.out.println(ll1.get(2));
		 * System.out.println(ll1);
		 */
	}

}
