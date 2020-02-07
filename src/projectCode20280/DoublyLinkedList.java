package projectCode20280;

import java.util.Iterator;

public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		//getters and setters
		public E getElement() {return element;}
		public Node<E> getPrev() { return prev;}
		public Node<E> getNext() { return next;}
		public void setPrev(Node<E> p) { prev = p; }
		public void setNext(Node<E> n) { next = n;}
	}
	
	private Node<E> headerNode;
	private Node<E> trailerNode;
	private int size = 0;
	
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// TODO
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}

	
}
