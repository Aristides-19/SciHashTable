package model;

/**
 * missing documentation
 *
 * @author Jesús Duarte & Arístides Pérez
 * @param <T> key datatype
 * @param <U> value datatype
 */
public class HashTable<T, U> {

    private Node<T, U>[] table;
    private int buckets; // must be a power of two
    private int size;
    private final double loadFactor = 0.75;

    public HashTable(int buckets) {
        this.buckets = buckets;
        this.size = 0;
        this.table = new Node[buckets];
    }

    public void put(T key, U value) {
        int hash = hashCode(key) % buckets;
        Node<T, U> newNode = new Node(key, value, hash);
        // ...
    }

    /**
     * This implementation uses the FNV-1 hashing algorithm. It uses 'T' object
     * toString method, then is converted to its byte-per-byte representation (8
     * bits), instead of using chars of 16 bits.
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

}
