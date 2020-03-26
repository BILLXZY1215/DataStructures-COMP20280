package projectCode20280;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class PQSort {
	
	//constructor 
	public PQSort() {
		
	}

	public static void main(String[] args) {
		int n = 10;
		LinkedList<Integer> arr = new Random().ints(0, 1000).limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));
		SinglyLinkedList<Integer> pq = new SinglyLinkedList<Integer>();
		
	}
}
