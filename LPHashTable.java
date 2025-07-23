/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
		int index = hashFunction(key);
		int startIndex = index; // Store the original index for the first empty slot
		this.incProbeCount(); // Every time findIndex is called, increment the probe count at least once

		while (table[index] != null) {
			if (table[index].equals(key)) {
				return index; // Key found
			} else {
				index = (index + 1) % table.length; // Move to the next index using linear probing
				this.incProbeCount(); // Increment probe count
				if (index == startIndex) {
					// We have looped through the entire table and found no empty slot
					return -1; // Table is full, no empty slot found
				}
			}
		}

		return index; // Key not found, return the first empty slot
	}

}
