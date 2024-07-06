package model;

/**
 * A HashTable implementation, it uses separate chaining technique to handle
 * collisions and FNV-1 hashing algorithm to generate hashcodes with high
 * dispersion. It has an average O(1) complexity for search, insert, and remove
 * operations.
 *
 * @author Jesús Duarte & Arístides Pérez
 * @param <K> key datatype
 * @param <V> value datatype
 */
public class HashTable<K, V> {

    private Node<K, V>[] table;
    private int buckets;
    private int size;
    private final float LOAD_FACTOR = 0.75F;

    /**
     * Buckets value must be a power of two or greater than 2 to minimize
     * collisions.
     *
     * @param buckets capacity
     * @throws IllegalArgumentException if buckets argument is not a power of
     * two or is less or equal than 2
     */
    public HashTable(int buckets) {

        double kVal = Math.log((double) buckets) / Math.log(2);
        if (Math.floor(kVal) != kVal || buckets <= 2) {
            throw new IllegalArgumentException("Buckets capacity value must be a power of two or greater than 2");
        }

        this.buckets = buckets;
        this.size = 0;
        this.table = new Node[buckets];
    }

    /**
     * It inserts a key-value pair to the table, if the size reachs 75% of
     * buckets capacity, it performs a rehashing for every element. So, in the
     * worst case complexity will be O(n), otherwise, it will be O(1). Even so,
     * the value can be {@code null}.
     *
     * @param key key to insert
     * @param value value to insert with key pair
     * @throws NullPointerException if key is null
     * @see #get(K)
     */
    public void put(K key, V value) {
        put(key, value, 0);
    }

    /**
     * Just a {@code put} public method util. It's used when it's performing a
     * rehashing.
     *
     * @param key key to insert
     * @param value value to insert
     * @param hash hashCode if it exists
     * @throws NullPointerException if key is {@code nulñ}
     * @see #rehash()
     */
    private void put(K key, V value, int hash) {
        if (key == null) {
            throw new NullPointerException("Key cannot be a null value");
        }

        hash = hash == 0 ? hashCode32(key) : hash;
        int index = hash % buckets;
        Node<K, V> newNode = new Node<>(key, value, hash);

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

        if ((float) size / buckets == LOAD_FACTOR) {
            rehash();
        }

    }

    /**
     * Get a value from a specified key if it's hashed, otherwise it will return
     * {@code null}. There is a possibility that the key is already hashed, but
     * its value pair is {@code null}.
     *
     * @param key
     * @return value from key-value pair, if it isn't hashed returns
     * {@code null}
     * @see #put(K, V)
     */
    public V get(K key) {
        int index = hashCode32(key) % buckets;
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.getKey().toString().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }

        return null;
    }

    /**
     * This implementation uses the FNV-1 hashing algorithm with 32 bits. It
     * uses key object     * toString method, then is converted to its byte-per-byte representation (8
     * bits), instead of using 16 bits char. Complexity O(n)
     *
     * @param key object to hash
     * @return key object hashCode
     */
    private int hashCode32(K key) {
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
        Node<K, V>[] oldTable = table;
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

    /**
     * To acknowledge if the hashTable is empty or not.
     *
     * @return boolean value representing whether is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
