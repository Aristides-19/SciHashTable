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

    /**
     * Function hash
     *
     * @param key the word which will be searched
     * @return value of hash
     */
    private int hashing1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += (key.charAt(i) * Math.pow(29, key.length() - (i + 1)));
        }
        hash = hash % buckets;
        return hash;
    }

    private int hashing2(String key) {
        String[] letter = key.split("");
        int hash = 0;
        for (int i = 0; i < letter.length; i++) {
            hash += (i + 1) * (Math.pow(29, ((letter.length) >> 1) - 1));
        }
        hash = hash % buckets;
        return hash;
    }

}
