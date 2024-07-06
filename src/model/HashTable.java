package model;

/**
 * A HashTable implementation, it uses separate chaining technique to handle
 * collisions and FNV-1 hashing algorithm to generate hashcodes with high
 * dispersion. It has an average O(1) complexity for search, insert, and remove
 * operations.
 *
 * @author Jesús Duarte & Arístides Pérez
 * @param <T> key datatype
 * @param <U> value datatype
 */
public class HashTable<T, U> {

    private Node<T, U>[] table;
    private int buckets;
    private int size;
    private final float loadFactor = 0.75F;

    /**
     * Buckets value must be a power of two.
     *
     * @param buckets capacity
     */
    public HashTable(int buckets) {
        this.buckets = buckets;
        this.size = 0;
        this.table = new Node[buckets];
    }

    /**
     * It inserts a key-value pair to the table, if the size reachs 75% of
     * buckets capacity, it performs a rehashing for every element. So, in the
     * worst case complexity will be O(n), otherwise, it will be O(1)
     *
     * @param key key to insert
     * @param value value to insert with key pair
     */
    public void put(T key, U value) {
        put(key, value, 0);
    }

    /**
     * Just a 'put' public method util. It's used when it's performing a
     * rehashing.
     *
     * @param key key to insert
     * @param value value to insert
     * @param hash hashCode if it exists
     */
    private void put(T key, U value, int hash) {
        hash = hash == 0 ? hashCode(key) : hash;
        int index = hash % buckets;
        Node<T, U> newNode = new Node<>(key, value, hash);

        if (table[index] != null) {
            Node aux = table[index];

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        } else {
            table[index] = newNode;
        }

        size++;

        if ((float) size / buckets == loadFactor) {
            rehash();
        }

    }

    /**
     * This implementation uses the FNV-1 hashing algorithm. It uses 'T' object
     * toString method, then is converted to its byte-per-byte representation (8
     * bits), instead of using 16 bits char. Complexity O(n)
       *
     * @param key object to hash
     * @return 'T' object hashCode
     */
    private int hashCode(T key) {
        byte[] keyBytes = key.toString().getBytes(); // to iterate for-each byte (8 bits)
        int FNV_PRIME = 0x01000193; // FNV Prime 32 bits
        int hash = 0x811C9DC5; // offset-basis 32 bits

        for (byte b : keyBytes) {
            hash *= FNV_PRIME;
            hash ^= b; // XOR to increase dispersion
        }

        return hash;
    }

    /**
     * It performs a rehashing of the table, duplicating the current buckets
     * capacity and relocating every key-value pair. It seems like O(n^2)
     * complexity, but in most cases there are just few collisions, so it will
     * be O(n) complexity.
     */
    private void rehash() {
        buckets *= 2;
        Node<T, U>[] oldTable = table;
        table = new Node[buckets];

        for (var e : oldTable) {
            while (e != null) {
                put(e.getKey(), e.getValue(), e.getHashCode());
                e = e.getNext();
            }
        }
    }

    /**
     * Current buckets capacity, must be a power of two.
     *
     * @return integer value representing capacity
     */
    public int getBuckets() {
        return buckets;
    }

    /**
     * Current key-value pairs added to the table, it will not exceed 75% of
     * current buckets capacity.
     *
     * @return integer value representing size
     */
    public int getSize() {
        return size;
    }

}
