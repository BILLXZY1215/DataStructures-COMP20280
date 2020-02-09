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
		public E getElement() { return element; }

		public Node<E> getNext() { return next;	}

		// modifier
		public void setNext(Node<E> n) {next = n;}

	}

	private Node<E> tail = null;
	private int size = 0;

	// constructor
	public CircularlyLinkedList() {}

	// access methods
	@Override
	public int size() {	return size;}

	@Override
	public boolean isEmpty() {return size == 0;}

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
	@Override
	public void add(int i, E e) {
		Node<E> newNode = new Node<E>(e, null);
		Node<E> prevNode = tail;
		Node<E> currNode = tail.getNext();
		
		for(int j=0; j<i; j++) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		
		prevNode.setNext(newNode);
		newNode.setNext(currNode);
		
		size++;

	}

	@Override
	public E remove(int i) {
		if (isEmpty()) {
			throw new RuntimeException("cant delete");
		}
		Node<E> headNode = tail.getNext();
		Node<E> cur = headNode;
		Node<E> prev = null;
		if (i == 0) {tail.setNext(headNode.getNext()); return headNode.getElement();}
		else if (i==size-1) {System.out.print(removeLast()); return null;}
		else {
				
			
			for(int j = 0; j<i; j++) {
				prev = cur;
				cur = cur.getNext();
			}
			
			prev.next = cur.next;
		}
		return cur.getElement();
	}

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
			System.out.print(cu.getElement() + ", ");
			cu = cu.next;
		}
		return null;
	}

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

	@Override
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();

	}

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
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		for (int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println(ll);

		ll.removeFirst();
		System.out.println(ll);

		System.out.println(ll.removeLast());
		System.out.println("***"+ll);
		System.out.println(ll.remove(7));
		System.out.println("***"+ll);
		
		ll.rotate();
		System.out.println(ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println(ll);

		ll.removeLast();
		ll.rotate();
		System.out.println(ll);
		ll.iterator();
		ll.add(2, 25);
		System.out.println("***"+ll);
		/*
		 * for (Integer e : ll) { System.out.println("value: " + e); }
		 */
	}
}
