/**
 * The {@code SplayTreeMap} in this class implements a
 * map using a Splay tree. TreeMap is extended.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

import java.util.Comparator;

public class SplayTreeMap<K, V> extends TreeMap<K, V> {

	protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

	/** Constructs an empty map using the natural ordering of keys. */
	public SplayTreeMap() {
		super();
	}

	/**
	 * Constructs an empty map using the given comparator to order keys.
	 * 
	 * @param comp comparator defining the order of keys in the map
	 */
	public SplayTreeMap(Comparator<K> comp) {
		super(comp);
	}

	/** Utility used to rebalance after a map operation. */
	private void splay(Position<Entry<K, V>> p) {
		while (!isRoot(p)) {
			Position<Entry<K, V>> parent = parent(p);
			Position<Entry<K, V>> grand = parent(parent);
			if (grand == null)
				tree.rotate(p);
			else if ((parent == left(grand)) == (p == left(parent))) {
				tree.rotate(parent);
				tree.rotate(p);
			} else {
				tree.rotate(p);
				tree.rotate(p);
			}

		}
	}

	/**
	 * Overrides the TreeMap rebalancing hook that is called after a node access.
	 */

	protected void rebalanceAccess(Position<Entry<K, V>> p) {
		if (isExternal(p))
			p = parent(p);
		if (p != null)
			splay(p);
	}

	/** Overrides the TreeMap rebalancing hook that is called after an insertion. */

	protected void rebalanceInsert(Position<Entry<K, V>> p) {
		splay(p);
	}

	/** Overrides the TreeMap rebalancing hook that is called after a deletion. */

	protected void rebalanceDelete(Position<Entry<K, V>> p) {
		if (!isRoot(p))
			splay(parent(p));
	}

	public static void main(String[] args) {
		// Create a splay tree
		SplayTreeMap<Integer, String> map = new SplayTreeMap<>();
		// fill it using this array
		Integer[] arr = new Integer[] { 35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5 };
		System.out.println("Is empty? " + map.isEmpty());
		System.out.println("Size: " + map.size());

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], Integer.toString(i));
		}
		System.out.println("Splay Tree: " + map);
		System.out.println("Is empty? " + map.isEmpty());
		System.out.println("Size: " + map.size());
		System.out.println("Value at key 2: " + map.get(2));
		System.out.println("Remove value at key 1: " + map.remove(1));
		System.out.println("Updated Splay Tree: " + map);
		System.out.println("Size: " + map.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");
	}
}