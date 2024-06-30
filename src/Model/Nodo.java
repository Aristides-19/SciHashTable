package Model;

/**
 *
 * @author jesus
 */
public class Nodo {
    String key;
    int value;
    Nodo next;

    public Nodo(String key, int value, Nodo next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
