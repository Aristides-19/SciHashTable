package model;

/**
 * Summary template, it needs a title and body String with keyWords and authors
 * String array
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String[] keyWords) {
        this.keyWords = keyWords;
    }
    
    
}
