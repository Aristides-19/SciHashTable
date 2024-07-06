package model;

/**
 * Node from the HashTable, contains key-value and a pointer to the next element
 * if there is a collision
 *
 * @author Jesús Duarte & Arístides Pérez
 * @param <T> key datatype
 * @param <U> value datatype
 */
class Node<T, U> {
    private T key;
    private U value;
    private Node next;
    private int position;

    protected Node(T key, U value, int position) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.position = position;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    
}
