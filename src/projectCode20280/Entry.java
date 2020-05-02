/**
 * The {@code Entry} in this class implements an
 * interface of a type entry.
 *
 * @author Aonghus Lawlor & Ahmed Jouda 
 */
package projectCode20280;

/**
 * Interface for a key-value pair.
 */
public interface Entry<K,V> {
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey();

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();
}