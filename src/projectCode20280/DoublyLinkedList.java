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
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		if (size != 0) {
            headerNode = headerNode.next;
            size--;
        }
 
        return null;
	}

	@Override
	public E removeLast() {
		Node<E> toDelete = trailerNode.getPrev();
		Node<E> predeccesor = toDelete.getPrev();
		Node<E> successor = toDelete.getNext();
		predeccesor.setNext(successor);
		successor.setPrev(predeccesor);
		size--;
		return null;
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
                 result += "->";
            }
            current = current.getNext();
        }
        return "List: " + result + "]";	}

	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addLast(9);
           ll.addFirst(2);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);

           ll.removeLast();
           System.out.println(ll);
           /*
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }*/
	}

	
}
