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
     * Count how many times a keyWord appears in summary {@code body}
     *
     * @param key keyword to match
     * @return integer representing the count
     */
    public int counterKey(String key) {
        Pattern pattern = Pattern.compile(key, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(body);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }

        return counter;
    }

    /**
     * Get a Summary Analysis, it shows how many times every keyword appear in
     * body
     *
     * @return String representation
     */
    @Override
    public String toString() {
        String toReturn = "**TÍTULO : " + title + "\n" + "**AUTORES : ";

        for (String a : authors) {
            toReturn += !a.equals(authors[authors.length - 1]) ? a + ", " : a;
        }
        toReturn += "\n**CUERPO :\n" + body + "\n**PALABRAS CLAVES :\n";

        for (String k : keyWords) {
            int matches = counterKey(k);
            toReturn += k + " : " + matches + "\n";
        }
        return toReturn;
    }
}
