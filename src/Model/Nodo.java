package Model;

/**
 *
 * @author jesus
 * @param <T> node can hold any object
 */
public class Nodo<T> {
    private String key;
    private T info;
    private Nodo next;

    public Nodo(String key, T info) {
        this.key = key;
        this.info = info;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
}
