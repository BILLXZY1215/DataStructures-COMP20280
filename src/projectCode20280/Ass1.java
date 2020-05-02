/**
 * The {@code Ass1} in this class implements a
 * sum method which sums two linked lists.
 *
 * @author Ahmed Jouda
 */
package projectCode20280;

import java.util.LinkedList;

public class Ass1 {
	public static LinkedList<Integer> sumtwo(LinkedList<Integer> first, LinkedList<Integer> second) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		int size1 = first.size();
		int size2 = second.size();
		int finalSize = size1;
		if (size2 > size1) {
			finalSize = size2;
			while (size2 > size1) {
				first.add(0, 0);
				size1++;
			}
		}
		if (size1 > size2) {
			finalSize = size1;
			while (size1 > size2) {
				second.add(0, 0);
				size2++;
			}
		}
		int sum = 0;
		int carry = 0;
		while ((finalSize) > 0) {
			sum = carry + first.get(finalSize - 1) + second.get(finalSize - 1);
			carry = (sum >= 10 ? 1 : 0);
			sum = sum % 10;
			res.add(0, sum);
			finalSize--;
		}
		if (carry == 1) {
			res.add(0, carry);
		}
		return res;
	}

	public static void main(String[] args) {
		LinkedList<Integer> first = new LinkedList<Integer>();
		first.add(3);
		first.add(5);
		first.add(3);
		LinkedList<Integer> second = new LinkedList<Integer>();
		second.add(8);
		second.add(2);
		second.add(6);
		System.out.println(first.toString() + " + " + second.toString() + " = " + sumtwo(first, second).toString());

		LinkedList<Integer> third = new LinkedList<Integer>();
		third.add(5);
		third.add(3);
		LinkedList<Integer> fourth = new LinkedList<Integer>();
		fourth.add(5);
		fourth.add(6);
		fourth.add(6);
		System.out.println(third.toString() + " + " + fourth.toString() + " = " + sumtwo(third, fourth).toString());

	}
}
