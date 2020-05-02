package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {

	DoublyLinkedList <E> l = new DoublyLinkedList<>();

	

	@Override
	public int size() {
		return l.size();
	}

	@Override
	public boolean isEmpty() {
		return l.isEmpty();
	}

	@Override
	public E first() {
		if(isEmpty())
			return null;
		else
			return l.first();
	}

	@Override
	public E last() {
		if(isEmpty())
			return null;
		else 
			return l.last();
	}

	@Override
	public void addFirst(E e) {
		l.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		l.addLast(e); 
	}

	@Override
	public E removeFirst() {
		return l.removeFirst();
	}

	@Override
	public E removeLast() {
		return l.removeLast(); 
	}
	
	public String toString() { 
		return l.toString(); 
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
				LinkedDeque<Integer> queue = new LinkedDeque<Integer>();
				
				// Initialize the queue
				for(int i = 0 ; i < 10 ; ++i)
					queue.addLast(new Integer(i));
				
				// Test cases
				System.out.println();
				System.out.println("Current queue : " + queue); // [ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9  ]
				System.out.println();
				
				queue.removeFirst();
				System.out.println("After FRONT DEQUEUE , Current queue : " + queue); // [ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 ]
				System.out.println();
				
				queue.removeLast();
				System.out.println("After BACK DEQUEUE , Current queue : " + queue); // [ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 ]
				System.out.println();
				
				queue.addFirst(-1);
				System.out.println("After FRONT ENQUEUE , Current queue : " + queue); // [ -1 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 ]
				System.out.println();
				
				System.out.println("The value at the front of queue : " + queue.first());
				System.out.println("The value at the rear of queue : " + queue.last());
		
	}
}