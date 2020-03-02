package projectCode20280;

public class LinkedStack<E> implements Stack<E> {

	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	//constructor
	public LinkedStack() {};
	
	@Override
	public int size() {return list.size();}

	@Override
	public boolean isEmpty() {return list.isEmpty();}

	@Override
	public void push(E e) {list.addFirst(e);}

	@Override
	public E top() {return list.get(0);}

	@Override
	public E pop() {return list.removeFirst();}
	
	//main
	public static void main(String[] args) {
		LinkedStack<Integer> bStack = new LinkedStack<>();
		bStack.push(4);
		bStack.push(6);
		System.out.println(bStack.size());
	}

}
