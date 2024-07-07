package model;

/**
 * A HashTable implementation, it uses separate chaining technique to handle
 * collisions and FNV-1 hashing algorithm to generate hashcodes with higher
 * dispersion. It has an average O(1) complexity for search, insert, and remove
 * operations.
 *
 * @author Arístides Pérez
 * @param <K> key datatype
 * @param <V> value datatype
 */
public class HashTable<K, V> {

    private Node<K, V>[] table;
    private int buckets;
    private int size;
    /**
     * A rehash will ocurr when the size reachs 75% of available buckets. Just
     * then, minimum probability of a collision won't be zero unless the buckets
     * are reduced to 16, so there is a minimum probability that a collision can
     * happen after first rehash that can be calculated as LOAD_FACTOR / 2.
     * Still, to save memory it will do a reverse rehash when size is less than
     * LOAD_FACTOR / 2. And, the maximum probability will always be below
     * LOAD_FACTOR.
     */
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
        if (!put(key, value, 0)) {
            size++;
        }

        if ((float) size / buckets == LOAD_FACTOR) {
            rehash(false);
        }
    }

    /**
     * Just a {@code put public method} util. It's used when it's performing a
     * rehashing. Also, return value it's just useful when there is a key that
     * has already been hashed to not increase the size.
     *
     * @param key key to insert
     * @param value value to insert
     * @param hash hashCode if it exists
     * @throws NullPointerException if key is {@code null}
     * @see #get(K)
     * @see #rehash()
     */
    private boolean put(K key, V value, int hash) {
        if (key == null) {
            throw new NullPointerException("Key cannot be a null value");
        }

        hash = hash == 0 ? hashCode32(key) : hash;
        int index = hash % buckets;

        // POSSIBLE COLLISION
        if (table[index] != null) {

            // FIRST KEY ALREADY EXISTS
            if (table[index].getKey().equals(key)) {
                table[index].setValue(value);
                return true;

            } else {
                Node aux = table[index].getNext();
                Node prev = table[index];

                // MIDDLE-LAST KEY ALREADY EXISTS
                while (aux != null) {
                    if (aux.getKey().equals(key)) {
                        aux.setValue(value);
                        return true;
                    }
                    prev = aux;
                    aux = aux.getNext();
                }

                // KEY DOESN'T EXIST
                prev.setNext(new Node<>(key, value, hash));
            }
        } else {
            table[index] = new Node<>(key, value, hash);
        }

        return false;
    }

    /**
     * Get a value from a given key if it's hashed, otherwise it will return
     * {@code null}. There is a possibility that the key is already hashed, but
     * its value pair is {@code null}. Complexity O(1)
     *
     * @param key key to get value pair
     * @return value from key-value pair, if it isn't hashed returns
     * {@code null}
     * @throws NullPointerException if key is {@code null}
     * @see #put(K, V)
     */
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be a null value");
        }

        int index = hashCode32(key) % buckets;
        Node<K, V> node = table[index];

        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }

        return null;
    }

    /**
     * Remove a value from a given if it's hashed. Complexity O(1) unless it
     * performs a rehashing, would be O(n).
     *
     * @param key key to remove key-value pair
     * @throws NullPointerException if key is {@code null}
     * @see #put(K, V)
     */
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be a null value");
        }

        int index = hashCode32(key) % buckets;
        Node<K, V> node = table[index];

        // FIRST CASE
        if (node != null && node.getKey().equals(key)) {
            table[index] = node.getNext();
        }

        // ELSE CASE
        if (node != null) {
            Node prev = node;
            node = node.getNext();
            while (node != null) {
                if (node.getKey().equals(key)) {
                    prev.setNext(node.getNext());
                    break;
                }

                prev = node;
                node = node.getNext();
            }
        }

        size--;
        if (buckets > 16) {
            if ((float) size / buckets < LOAD_FACTOR / 2) {
                rehash(true);
            }
        }
    }

    /**
     * This implementation uses the FNV-1 hashing algorithm with 32 bits. It
     * uses key object toString method, then is converted to its byte-per-byte
     * representation (8 bits), instead of using 16 bits char. Complexity O(n)
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

        return hash < 0 ? hash * -1 : hash;
    }

    /**
     * It performs a rehashing of the table, duplicating the current buckets
     * capacity and relocating every key-value pair. It seems like O(n^2)
     * complexity, but in most cases there are just few collisions, so it will
     * be O(n) complexity.
     */
    private void rehash(boolean reverse) {
        buckets = reverse ? buckets / 2 : buckets * 2;
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

    /**
     * Generates an array of hashed keys.
     *
     * @return array of hashed keys
     */
    public K[] keysToArray() {
        K[] keys = (K[]) new Object[size];
        int i = 0;
        for (var e : table) {
            while (e != null) {
                keys[i] = e.getKey();
                e = e.getNext();
                i++;
            }
        }
        return keys;
    }

    /**
     * Generates an array of values from key-value pairs.
     *
     * @return array of values from key-value pairs
     */
    public V[] valuesToArray() {
        V[] values = (V[]) new Object[size];
        int i = 0;
        for (var e : table) {
            while (e != null) {
                values[i] = e.getValue();
                e = e.getNext();
                i++;
            }
        }
        return values;
    }

    /**
     * A String representation of the Hash Table, it shows a key-value pair line
     * by line.
     *
     * @return a string representing table
     */
    @Override
    public String toString() {
        String toReturn = "";
        for (var e : table) {
            while (e != null) {
                toReturn += e.getKey().toString() + " : "
                        + e.getValue().toString() + "\n";
                e = e.getNext();
            }
        }
        return toReturn;
    }

}
