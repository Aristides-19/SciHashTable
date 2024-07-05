package model;

/**
 * Summary template, it needs a title, authors, body and keyWords from the
 * summary
 *
 * @author Jesús Duarte & Arístides Pérez
 */
public class Summary {
    private String title;
    private String[] authors;
    private String body;
    private String[] keyWords;

    public Summary(String title, String[] authors, String body, String[] keyWords) {
        this.title = title;
        this.authors = authors;
        this.body = body;
        this.keyWords = keyWords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getSummary() {
        return body;
    }

    public void setSummary(String summary) {
        this.body = summary;
    }

    public String[] getKeys() {
        return keyWords;
    }

    public void setKeys(String[] keys) {
        this.keyWords = keys;
    }
    
    
}
