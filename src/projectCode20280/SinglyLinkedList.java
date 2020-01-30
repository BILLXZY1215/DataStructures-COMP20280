package projectCode20280;

import java.util.Iterator;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

public class SinglyLinkedList<E> implements List<E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	private class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		//Accessor Methods
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		//Modifier Methods
		public void setNext(Node<E> n) { next = n;}
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
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
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}	
	

	@Override
	public E removeFirst() {
		if (isEmpty()) {
            return null;
        }
        if (size == 0) {
            tail = null;
        }

        return remove(head.getNext());
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(E e) {
		head= new Node<E>(e, head);
		if (size == 0) {
            tail = head;
        }
		size++;
		
	}

	@Override
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
		
	}
	

    
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
