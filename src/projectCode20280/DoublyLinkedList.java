package projectCode20280;

import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.LASTORE;

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
	
	//constructor
	public DoublyLinkedList( ) {
		headerNode = new Node<>(null, null, null); // create header
		trailerNode = new Node<>(null, headerNode, null); // trailer is preceded by header
		headerNode.setNext(trailerNode); // header is followed by trailer
	 }
	
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

	public E first() {
		if (isEmpty()) return null;
		return headerNode.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return trailerNode.getPrev().getElement();
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E get(int i) {
		Node<E> currNode = headerNode.getNext();
		for (int j = 0; j < i; j++) {
			currNode = currNode.getNext();
		}
		return currNode.getElement();
	}

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
		}
		else {
			Node<E> cuNode = headerNode.getNext();
			while (cuNode.getNext()!=null) {
				System.out.print(cuNode.getElement() + ", ");
				cuNode = cuNode.getNext();
			}
		}
		
		return null;
	}



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
	

	@Override
	public void addFirst(E e) {
		addBetween(e, headerNode, headerNode.getNext());
				
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailerNode.getPrev(), trailerNode);
				
	}
	
	
	
	@Override
	public String toString() {
		String result = "[";
        Node<E> current = headerNode.getNext();
        while(current.getNext() != null){
            result += current.getElement();
            if(current.getNext().getNext() != null){
                 result += ", ";
            }
            current = current.getNext();
        }
        return result + "]";	}

	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addLast(9);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           System.out.println("******" + ll.get(2));
           ll.add(2, 3);
           System.out.println(ll);
           System.out.println(ll.size());
           System.out.println("******" +ll.removeFirst());
           System.out.println(ll);

           System.out.println("------" +ll.removeLast());
           System.out.println(ll);
           System.out.println("------" +ll.remove(1));
           System.out.println(ll);
           ll.iterator();
           System.out.println(ll.size());
           /*
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }*/
           
           DoublyLinkedList<Integer> ll1 = new DoublyLinkedList<Integer>(); 
           
           ll1.addFirst(0); ll1.addFirst(1); ll1.addFirst(3); ll1.addFirst(4); ll1.addFirst(5); 
           ll1.add(3, 2); 
           System.out.println(ll1);
           ll1.addFirst(-100); ll1.addLast(+100); System.out.println(ll1);
           ll1.removeFirst(); ll1.removeLast(); System.out.println(ll1);
           
           ll1.removeFirst(); System.out.println(ll1);
           ll1.removeLast(); System.out.println(ll1);
           ll1.removeFirst(); System.out.println(ll1);
           ll1.addFirst(9999); ll1.addFirst(8888); ll1.addFirst(7777);
 
           System.out.println(ll1); System.out.println(ll1.get(0)); System.out.println(ll1.get(1)); System.out.println(ll1.get(2)); System.out.println(ll1);
	}

	
}
