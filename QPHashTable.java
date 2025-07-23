/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable  extends HashTable {


    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */
    public QPHashTable() { super(); }

    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using quadratic probing.
		int index = hashFunction(key);
		int startIndex = index; // Original index
		int p = 1; //Number of probes performed
		this.incProbeCount(); // Every time findIndex is called, increment the probe count at least once

		while (table[index] != null) {
			if (table[index].equals(key)) {
				return index;
			} else {
				if (p >= table.length) {
					return -1; // We assume that probing has failed if p >= table size, so return -1
				} else {
					index = (startIndex + p * p) % table.length; // Move to next index using quadratic probing
					this.incProbeCount(); // Increment probe count
					p++;
				}
			}
		}

		return index; //Key not found, return the first empty slot
    }
}
