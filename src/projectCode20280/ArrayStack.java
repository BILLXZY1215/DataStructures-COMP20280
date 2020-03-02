package projectCode20280;

public class ArrayStack<E> implements Stack<E> {

	public static final int CAPACITY = 100;		//default array capacity
	private E[] data;							//generic array for storage
	private int t = -1;							//index of the top element of the stack
	
	
	public ArrayStack() {this(CAPACITY);}		//constructs stack with default capacity	
	
	//constructor
		public ArrayStack(int capacity) {
			data = (E[]) new Object[capacity];
		}
	

	@Override
	public int size() {return (t+1);}

	@Override
	public boolean isEmpty() {return (t==-1);}

	@Override
	public void push(E e) throws IllegalArgumentException{
		if (size() == data.length) {
			throw new IllegalArgumentException("Stack is full");
		}	
		data[++t] = e;
	}

	@Override
	public E top() {
		if (isEmpty()) {
			return null;
		}		
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = data[t];
		data[t] = null;
		t--;
		return answer;
	}
	
	E peek() 
    { 
        if (t < 0) { 
            System.out.println("Stack Underflow"); 
            return null; 
        } 
        else { 
            E x = data[t]; 
            return x; 
        } 
    } 

	//main
	public static void main(String[] args) {
		ArrayStack<Integer> bStack = new ArrayStack<>(21);
		bStack.push(4);
		bStack.push(6);
		System.out.println(bStack.peek());
	}
}
