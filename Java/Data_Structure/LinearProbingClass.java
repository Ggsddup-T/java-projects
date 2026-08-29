import java.util.*;

/**
 * Linear Probing Hash Table — stores key-value pairs in an array.
 * When two keys hash to the same index (collision), the table probes
 * forward one slot at a time until an empty slot is found.
 */
class LinearProbingHashTable {
    private int currentSize; // number of key-value pairs stored
    private int maxSize;     // capacity of the underlying arrays
    private String[] keys;   // keys at each index (null = empty slot)
    private String[] vals;   // values paired with keys at the same index

    /**
     * Creates a hash table with the given capacity.
     * Arrays are initialized to null (empty slots).
     */
    public LinearProbingHashTable(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    /**
     * Maps a key to an array index using Java's hashCode and modulo.
     * Same key always produces the same starting index.
     */
    private int hash(String key) {
        return key.hashCode() % maxSize;
    }

    /**
     * Inserts or updates a key-value pair.
     * - If the key is new: place it in the first empty slot starting at hash(key).
     * - If the key exists: update its value.
     * - On collision: probe to the next index (i + 1) % maxSize (wraps around).
     */
    public void insert(String key, String val) {
        int tmp = hash(key); // ideal/home index for this key
        int i = tmp;         // current index being examined

        do {
            // Empty slot found — insert new key-value pair here
            if (keys[i] == null) {
                keys[i] = key;
                vals[i] = val;
                currentSize++;
                return;
            }

            // Key already exists at this slot — update value only
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }

            // Collision: another key occupies this slot — probe to next index
            i = (i + 1) % maxSize;

        } while (i != tmp); // stop if we've wrapped around the whole table (full)
    }

    /** Prints all non-empty entries in the hash table. */
    public void printHashTable() {
        System.out.println("\nEntries in the hash table:");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println("Key: " + keys[i] + ", Value: " + vals[i]);
    }
}

/**
 * Demo driver: inserts five city entries into a small hash table (capacity 5)
 * and prints the final table layout (which may differ from insertion order due to probing).
 */
public class LinearProbingClass {

    public static void main(String[] args) {
        LinearProbingHashTable lpht = new LinearProbingHashTable(5);

        lpht.insert("10", "Amsterdam");
        lpht.insert("20", "London");
        lpht.insert("30", "Paris");
        lpht.insert("40", "New York");
        lpht.insert("50", "New Jersey");

        lpht.printHashTable();
    }
}
