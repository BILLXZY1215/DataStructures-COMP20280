package projectCode20280;

import java.util.Random;

public class PQSort {
	
	//constructor 
	public PQSort() {
		
	}
	
	public static boolean isSorted(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] > array[i + 1])
	            return false;
	    }
	    return true;
	}
	
	public static void filler(SinglyLinkedList<Integer> ll, int n) {
		Random rand = new Random();
		for (int i = 0; i < n; ++i) {
			ll.addLast(rand.nextInt(Integer.MAX_VALUE));
		}
	}
	
	public static Integer removeMin(SinglyLinkedList<Integer> ll) {
		int minimum = 0;
		Integer valueAtMinimum = ll.get(minimum);
		for (int i = 0; i < ll.size(); ++i) {
			Integer currentValue = ll.get(i);
			if (currentValue<valueAtMinimum) {
				valueAtMinimum=currentValue;
				minimum=i;
			}
		}
		ll.remove(minimum);
		return valueAtMinimum;
	}
	
	

	public static void main(String[] args) {
		int n = 10;
		while(n<1000) {
		SinglyLinkedList<Integer> arr = new SinglyLinkedList<Integer>();
		filler(arr, n);
		//System.out.println(arr);
		
		long startTime = System.nanoTime();
		SinglyLinkedList<Integer> pq = new SinglyLinkedList<Integer>();
		
		while (!arr.isEmpty()) {
			pq.addLast(arr.removeFirst());
			
		}
		
		while (!pq.isEmpty()) {
			arr.addLast(removeMin(pq));
			
		}
		long endTime = System.nanoTime();
		long diff = endTime - startTime;
		//System.out.println(arr);
		System.out.println("Size: " + arr.size() + " | Is it sorted? " + arr.isSortedAsc() + " | Time taken (ns): " + diff);
		n *= 1.1;
		}
	}
}
