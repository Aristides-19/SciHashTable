package Model;

/**
 *
 * @author jesus
 */
public class Investigation {
    String title;
    Nodo[] authors;
    String summary;
    Nodo[] keys;

    public Investigation(String title, Nodo[] authors, String summary, Nodo[] keys) {
        this.title = title;
        this.authors = authors;
        this.summary = summary;
        this.keys = keys;
    }
}
