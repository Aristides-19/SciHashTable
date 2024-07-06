package model;

/**
 * Node from the HashTable, contains key-value and a pointer to the next element
 * if there is a collision
 *
 * @author Jesús Duarte & Arístides Pérez
 * @param <K> key datatype
 * @param <V> value datatype
 */
class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;
    private int hashCode;

    protected Node(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.hashCode = hashCode;
    }

    public K getKey() {
        return key;
    }

    protected void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    protected void setValue(V value) {
        this.value = value;
    }

    protected Node getNext() {
        return next;
    }

    protected void setNext(Node next) {
        this.next = next;
    }

    protected int getHashCode() {
        return hashCode;
    }

    protected void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    
}
