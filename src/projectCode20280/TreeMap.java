package projectCode20280;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a sorted map using a binary search tree.
 */

public class TreeMap<K, V> extends AbstractSortedMap<K, V> {

	// We reuse the LinkedBinaryTree class. A limitation here is that we only use the key.
	protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

	/** Constructs an empty map using the natural ordering of keys. */
	public TreeMap() {
		super(); // the AbstractSortedMap constructor
		tree.addRoot(null); // create a sentinel leaf as root
	}

    public TreeMap(Comparator<K> comp) {
        super(comp);              // the AbstractSortedMap constructor
        tree.addRoot(null);       // create a sentinel leaf as root
    }
    
	/**
	 * Returns the number of entries in the map.
	 * 
	 * @return number of entries in the map
	 */
	@Override
	public int size() {
		return (tree.size() - 1) / 2; // only internal nodes have entries
	}

	/** Utility used when inserting a new entry at a leaf of the tree 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException */
	private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) throws IllegalArgumentException, IllegalAccessException {
		tree.set(p, entry);
		tree.addLeft(p, null);
		tree.addRight(p, null);
	}

	// Some notational shorthands for brevity (yet not efficiency)
	protected Position<Entry<K, V>> root() {
		return tree.root();
	}

	protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
		return tree.parent(p);
		
	}

	protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
		return tree.left(p);
	}

	protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
		return tree.right(p);
	}

	protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
		return tree.sibling(p);
	}

	protected boolean isRoot(Position<Entry<K, V>> p) {
		return tree.isRoot(p);
	}

	protected boolean isExternal(Position<Entry<K, V>> p) {
		return tree.isExternal(p);
	}

	protected boolean isInternal(Position<Entry<K, V>> p) {
		return tree.isInternal(p);
	}

	protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
		tree.set(p, e);
	}

	protected Entry<K, V> remove(Position<Entry<K, V>> p) {
		return tree.remove(p);
	}

	/**
	 * Returns the position in p's subtree having the given key (or else the
	 * terminal leaf).
	 * 
	 * @param key a target key
	 * @param p   a position of the tree serving as root of a subtree
	 * @return Position holding key, or last node reached during search
	 */
	private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
		if (isExternal(p)) 
			return p;
		int comp = compare(key, p.getElement());
		if (comp == 0) 
			return p;
		else if (comp<0) 
			return treeSearch(left(p), key);
		else return treeSearch(right(p), key);
	}

	/**
	 * Returns position with the minimal key in the subtree rooted at Position p.
	 * 
	 * @param p a Position of the tree serving as root of a subtree
	 * @return Position with minimal key in subtree
	 */
	protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
		Position<Entry<K, V>> curr = p;
		while (isInternal(curr)) {
			curr = left(curr);			
		}
		return parent(curr);
	}

	/**
	 * Returns the position with the maximum key in the subtree rooted at p.
	 * 
	 * @param p a Position of the tree serving as root of a subtree
	 * @return Position with maximum key in subtree
	 */
	protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
		Position<Entry<K,V>> walk = p;
		while (isInternal(walk)) 
			walk = right(walk); 
		return parent(walk); 
	}

	/**
	 * Returns the value associated with the specified key, or null if no such entry
	 * exists.
	 * 
	 * @param key the key whose associated value is to be returned
	 * @return the associated value, or null if no such entry exists
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		checkKey(key);
		Position<Entry<K, V>> p = treeSearch(root(), key);
		rebalanceAccess(p);
		if (isExternal(p)) return null;
		return p.getElement().getValue();
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
		checkKey(key);
		Entry<K, V> newEntry = new MapEntry<>(key, value);
		Position<Entry<K, V>> p = treeSearch(root(), key);
		if (isExternal(p)) {
			try {
				expandExternal(p, newEntry);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rebalanceInsert(p);
			return null;
		}
		else {
			V old = p.getElement().getValue();
			set(p, newEntry);
			rebalanceAccess(p);
			return old;
		}
	}

	/**
	 * Removes the entry with the specified key, if present, and returns its
	 * associated value. Otherwise does nothing and returns null.
	 * 
	 * @param key the key whose entry is to be removed from the map
	 * @return the previous value associated with the removed key, or null if no
	 *         such entry exists
	 */
	@Override
	public V remove(K key) throws IllegalArgumentException {
		 checkKey(key); // may throw IllegalArgumentException 
		 Position<Entry<K,V>> p = treeSearch(root(), key); 
		 if (isExternal(p)) { // key not found 
			 rebalanceAccess(p); // hook for balanced tree subclasses
			 return null;  
			 } else {  
				 V old = p.getElement().getValue(); 
				 if (isInternal(left(p)) && isInternal(right(p))) { // both children are internal 
					 Position<Entry<K,V>> replacement = treeMax(left(p)); 
					 set(p, replacement.getElement()); 
					 p = replacement; 
					 } // now p has at most one child that is an internal node 
				 Position<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p)); 
				 Position<Entry<K,V>> sib = sibling(leaf); 
				 remove(leaf); 
				 remove(p); // sib is promoted in p’s place 
				 rebalanceDelete(sib); // hook for balanced tree subclasses 
				 return old;  
				 }
			 }


	// additional behaviors of the SortedMap interface
	/**
	 * Returns the entry having the least key (or null if map is empty).
	 * 
	 * @return entry with least key (or null if map is empty)
	 */
	@Override
	public Entry<K, V> firstEntry() {
		if (isEmpty())
			return null;
		return treeMin(root()).getElement();
	}

	/**
	 * Returns the entry having the greatest key (or null if map is empty).
	 * 
	 * @return entry with greatest key (or null if map is empty)
	 */
	@Override
	public Entry<K, V> lastEntry() {
		 if (isEmpty()) return null;  
		 return treeMax(root()).getElement(); 
	}

	/**
	 * Returns the entry with least key greater than or equal to given key (or null
	 * if no such key exists).
	 * 
	 * @return entry with least key greater than or equal to given (or null if no
	 *         such entry)
	 * @throws IllegalArgumentException if the key is not compatible with the map
	 */
	@Override
	public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
		checkKey(key);                              // may throw IllegalArgumentException
	    Position<Entry<K,V>> p = treeSearch(root(), key);
	    if (isInternal(p)) return p.getElement();   // exact match
	    while (!isRoot(p)) {
	      if (p == left(parent(p)))
	        return parent(p).getElement();          // parent has next greater key
	      else
	        p = parent(p);
	    }
	    return null;                                // no such ceiling exists
	}

	/**
	 * Returns the entry with greatest key less than or equal to given key (or null
	 * if no such key exists).
	 * 
	 * @return entry with greatest key less than or equal to given (or null if no
	 *         such entry)
	 * @throws IllegalArgumentException if the key is not compatible with the map
	 */
	@Override
	public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
		 checkKey(key); // may throw IllegalArgumentException  
		 Position<Entry<K,V>> p = treeSearch(root(), key);  
		 if (isInternal(p)) return p.getElement(); // exact match 
		 while (!isRoot(p)) { 
			 if (p == right(parent(p))) 
				 return parent(p).getElement(); // parent has next lesser key  
			 else 
				 p = parent(p); 
			 } 
		 return null; 
	}

	/**
	 * Returns the entry with greatest key strictly less than given key (or null if
	 * no such key exists).
	 * 
	 * @return entry with greatest key strictly less than given (or null if no such
	 *         entry)
	 * @throws IllegalArgumentException if the key is not compatible with the map
	 */
	@Override
	public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
		 checkKey(key); // may throw IllegalArgumentException 
		 Position<Entry<K,V>> p = treeSearch(root(), key); 
		 if (isInternal(p) && isInternal(left(p))) 
			 return treeMax(left(p)).getElement(); // this is the predecessor to p 
		 // otherwise, we had failed search, or match with no left child 
		 while (!isRoot(p)) { 
			 if (p == right(parent(p))) 
				 return parent(p).getElement(); // parent has next lesser key 
			 else 
				 p = parent(p); 
			 }
		 return null;
		 }

	/**
	 * Returns the entry with least key strictly greater than given key (or null if
	 * no such key exists).
	 * 
	 * @return entry with least key strictly greater than given (or null if no such
	 *         entry)
	 * @throws IllegalArgumentException if the key is not compatible with the map
	 */
	@Override
	public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
		 checkKey(key);                               // may throw IllegalArgumentException
		    Position<Entry<K,V>> p = treeSearch(root(), key);
		    if (isInternal(p) && isInternal(right(p)))
		      return treeMin(right(p)).getElement();     // this is the successor to p
		    // otherwise, we had failed search, or match with no right child
		    while (!isRoot(p)) {
		      if (p == left(parent(p)))
		        return parent(p).getElement();           // parent has next lesser key
		      else
		        p = parent(p);
		    }
		    return null;                                 // no such greater key exists
	}

	// Support for iteration
	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
		for (Position<Entry<K, V>> p: tree.inorder()) 
			if (isInternal(p)) buffer.add(p.getElement());
		return buffer;
	}

	/**
	 * Returns an iterable containing all entries with keys in the range from
	 * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
	 * 
	 * @return iterable with keys in desired range
	 * @throws IllegalArgumentException if <code>fromKey</code> or
	 *                                  <code>toKey</code> is not compatible with
	 *                                  the map
	 */
	@Override
	public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());
		if (compare(fromKey, toKey)<0) 
			subMapRecurse(fromKey, toKey, root(), buffer);
		return buffer;
	}

	private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> p, ArrayList<Entry<K, V>> buffer) {
		if (isInternal(p)) 
			if (compare(p.getElement(), fromKey)<0) 
				subMapRecurse(fromKey, toKey, right(p), buffer);
			else {
				subMapRecurse(fromKey, toKey, left(p), buffer);
				if (compare(p.getElement(), toKey)<0) {
					buffer.add(p.getElement());
					subMapRecurse(fromKey, toKey, right(p), buffer);
				}
			}
	}

	// remainder of class is for debug purposes only
	/** Prints textual representation of tree structure (for debug purpose only). */
	protected void dump() {
		dumpRecurse(root(), 0);
	}

	/** This exists for debugging only */
	private void dumpRecurse(Position<Entry<K, V>> p, int depth) {
		String indent = (depth == 0 ? "" : String.format("%" + (2 * depth) + "s", ""));
		if (isExternal(p))
			System.out.println(indent + "leaf");
		else {
			System.out.println(indent + p.getElement());
			dumpRecurse(left(p), depth + 1);
			dumpRecurse(right(p), depth + 1);
		}
	}
	
	//helper methods
	public String toString(){
	    
		
		String string = "" + tree.inorder();
		
		return string;
		
	}

	public static void main(String[] args) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		
		treeMap.put(0, 0);
		//System.out.println(treeMap.entrySet());
		treeMap.put(2, 1);
		//System.out.println(treeMap.entrySet());
		treeMap.remove(0);
		//System.out.println(treeMap.entrySet());
		//System.out.println(treeMap.keySet().toString());
		///System.out.println(treeMap);
		
		TreeMap<Integer, String> map = new TreeMap<>();
		Integer[] arr = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(int i = 0; i<arr.length; i++) {
			map.put(arr[i], Integer.toString(i));
		}
		
		System.out.println(map.toString());
		
		TreeMap<Integer, String> map2 = new TreeMap<>();
		//java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
		Integer[] arr2 = new Integer[] {35,26,15,24,33,4,12,1,23,21,2,5};

		for(int j = 0; j < arr2.length; j++) {
			map2.put(arr2[j], Integer.toString(j));
		}
		System.out.println(map2.toString());
		
		/*Random rnd = new Random();
		int n = 16;
		java.util.List<Integer> rands = rnd.ints(1, 1000).limit(n).distinct().boxed().collect(Collectors.toList());

		for(Integer i : rands) {
			treeMap.put(i, i);
		}
		
		System.out.println("tree entries: " + treeMap.entrySet());
		
		treeMap.remove(rands.get(1));

		System.out.println("tree entries after removal: " + treeMap.entrySet());*/
		
		//BinaryTreePrinter<Entry<Integer, Integer>> btp = new BinaryTreePrinter<>(treeMap.tree);
		//System.out.println(btp.print());
	}

	/** Overrides the TreeMap rebalancing hook that is called after an insertion. */
	protected void rebalanceInsert(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		
	}

	/** Overrides the TreeMap rebalancing hook that is called after a deletion. */
	protected void rebalanceDelete(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		
	}

	/** Overrides the TreeMap rebalancing hook that is called after a node access. */
	protected void rebalanceAccess(Position<Entry<K, V>> p) {
		// TODO Auto-generated method stub
		
	}
	
    protected void rotate(Position<Entry<K, V>> p) {
        // TODO
    }
    
}