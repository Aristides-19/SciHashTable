package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    /**
    * Count how many times a key appears in a text
    *
    * @author Jesús Duarte & Arístides Pérez
     * @param summary
     * @param key
     * @return counter
    */
    public int counterKey (String summary, String key){
        Pattern pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(summary);

        int contador = 0;
        while (matcher.find()) {
            contador++;
        }

        return contador;
    }
}
