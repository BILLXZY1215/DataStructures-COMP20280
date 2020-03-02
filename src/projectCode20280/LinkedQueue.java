package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();	//empty list
	
	//constructor...relies on empty list
	public LinkedQueue() {}
	

	@Override
	public int size() {return list.size();}

	@Override
	public boolean isEmpty() {return list.isEmpty();}

	@Override
	public void enqueue(E e) {list.addLast(e);}

	@Override
	public E first() {return list.get(0);}

	@Override
	public E dequeue() {return list.removeFirst();}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
