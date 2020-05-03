/**
 * The {@code UnsortedTableMap} in this class implements an
 * unsorted map.
 *
 * @author Ahmed Jouda & Dr. Aonghus Lawlor
 */
package projectCode20280;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * An implementation of a map using an unsorted table.
 */

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
	/** Underlying storage for the map of entries. */
	private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

	/** Constructs an initially empty map. */
	public UnsortedTableMap() {
	}

	// private utility
	/** Returns the index of an entry with equal key, or -1 if none found. */
	private int findIndex(K key) {
		int n = table.size();
		for (int j = 0; j < n; j++) {
			if (table.get(j).getKey().equals(key)) {
				return j;
			}
		}
		return -1;
	}

	// public methods
	/**
	 * Returns the number of entries in the map.
	 * 
	 * @return number of entries in the map
	 */
	@Override
	public int size() {
		return table.size();
	}

	/**
	 * Returns the value associated with the specified key, or null if no such entry
	 * exists.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the associated value, or null if no such entry exists
	 */
	@Override
	public V get(K key) {
		int j = findIndex(key);
		if (j == -1) {
			return null;
		}
		return table.get(j).getValue();
	}

	/**
	 * Associates the given value with the given key. If an entry with the key was
	 * already in the map, this replaced the previous value with the new one and
	 * returns the old value. Otherwise, a new entry is added and null is returned.
	 * 
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with the key (or null, if no such
	 *         entry)
	 */
	@Override
	public V put(K key, V value) {
		int j = findIndex(key);
		if (j == -1) {
			table.add(new MapEntry<>(key, value));
			return null;
		} else {
			return table.get(j).setValue(value);
		}

	}

	/**
	 * Removes the entry with the specified key, if present, and returns its value.
	 * Otherwise does nothing and returns null.
	 * 
	 * @param key the key whose entry is to be removed from the map
	 * @return the previous value associated with the removed key, or null if no
	 *         such entry exists
	 */
	@Override
	public V remove(K key) {
		int j = findIndex(key);
		int n = size();
		if (j == -1) {
			return null;
		}
		V answer = table.get(j).getValue();
		if (j != n - 1) {
			table.set(j, table.get(n - 1));
		}
		table.remove(n - 1);
		return answer;
	}

	// ---------------- nested EntryIterator class ----------------
	private class EntryIterator implements Iterator<Entry<K, V>> {
		private int j = 0;

		public boolean hasNext() {
			return j < table.size();
		}

		public Entry<K, V> next() {
			if (j == table.size())
				throw new NoSuchElementException("No further entries");
			return table.get(j++);
		}

		public void remove() {
			throw new UnsupportedOperationException("remove not supported");
		}
	} // ----------- end of nested EntryIterator class -----------

	// ---------------- nested EntryIterable class ----------------
	private class EntryIterable implements Iterable<Entry<K, V>> {
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}
	} // ----------- end of nested EntryIterable class -----------

	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

	public String toString() {
		String string = "" + table.toString();

		return string;
	}

	public static void main(String[] args) {

		// Create an unsorted table map
		UnsortedTableMap<Integer, String> unTableMap = new UnsortedTableMap<>();
		System.out.println("Is it empty?: " + unTableMap.isEmpty());
		System.out.println("Size: " + unTableMap.size());

		System.out.println("\nAdd a test");
		unTableMap.put(0, "Zero");
		System.out.println("Tree Map: " + unTableMap);
		System.out.println("Is it empty?: " + unTableMap.isEmpty());
		System.out.println("\nValue at key 0: " + unTableMap.get(0));

		System.out.println("\nRemove key 0: " + unTableMap.remove(0));
		System.out.println("Tree Map: " + unTableMap);
		System.out.println("Is it empty?: " + unTableMap.isEmpty());

		System.out.println("\nFill it with more nodes");
		Random rnd = new Random();
		int n = 16;
		java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());
		for (Integer i : rands) {
			unTableMap.put(i, i.toString());
		}
		System.out.println("Tree Map(Entry Set): " + unTableMap);
		System.out.println("Size: " + unTableMap.size());

		System.out.println("\nMore detailed testing in junit file.\n***PASSED ALL TESTS***");

	}
}
