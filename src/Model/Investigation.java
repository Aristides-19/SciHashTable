package Model;

/**
 *
 * @author jesus
 */
public class Investigation {
    private String title;
    private Nodo[] authors;
    private String summary;
    private Nodo[] keys;

    public Investigation(String title, Nodo[] authors, String summary, Nodo[] keys) {
        this.title = title;
        this.authors = authors;
        this.summary = summary;
        this.keys = keys;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Nodo[] getAuthors() {
        return authors;
    }

    public void setAuthors(Nodo[] authors) {
        this.authors = authors;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Nodo[] getKeys() {
        return keys;
    }

    public void setKeys(Nodo[] keys) {
        this.keys = keys;
    }
    
    
}
