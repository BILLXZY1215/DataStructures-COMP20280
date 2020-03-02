package projectCode20280;

public class BoundedStack<E> {

	public static final int DEFAULT_BOUND = 32;

    private final E[] elements;
    private  int size;
    private int t = -1;	

    public BoundedStack() { this(DEFAULT_BOUND); }
    
	public BoundedStack(int bound) {
		elements = (E[])new Object[bound];
        size = 0;
	}
	
	public int getSize() {
	    return size;
	}
	
	public int getBound() { return elements.length; }
	
	public boolean isEmpty() {return t==-1;}
	
	
	public void push(E e) throws IllegalArgumentException{
		if (getSize() == elements.length) {
			throw new IllegalArgumentException("Stack is full");
		}	
		elements[++t] = e;
	}

	
	public E top() {
		if (isEmpty()) {
			return null;
		}		
		return elements[t];
	}

	
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E answer = elements[t];
		elements[t] = null;
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
            E x = elements[t]; 
            return x; 
        } 
    } 
	
	//main
		public static void main(String[] args) {
			BoundedStack<Integer> bStack = new BoundedStack<>(3);
			bStack.push(4);
			bStack.push(6);
			bStack.push(7);
			System.out.println(bStack.peek());
		}
}
