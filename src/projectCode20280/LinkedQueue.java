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
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String newString = "[" + list.get(0);
		
		for (int i = 1; i < size(); i++) {
			newString = newString + ", " +list.get(i);
		}

		return newString+"]";
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> s = new LinkedQueue<>();
		for(int i = 0; i < 10; ++i)
			s.enqueue(i);
		System.out.print(s);

	}

}
