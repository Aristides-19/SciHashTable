package controller;

import java.util.LinkedList;
import view.FileSelector;
import model.HashTable;
import model.Summary;

/**
 * App class contains Main method && search methods.
 *
 * @author Arístides Pérez & Jesús Duarte
 */
public class App {

    static private HashTable<String, Summary> summaries = new HashTable<>(16);
    static private HashTable<String, LinkedList<Summary>> keyWords = new HashTable<>(16);
    static private HashTable<String, LinkedList<Summary>> authors = new HashTable<>(16);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSelector launchView = new FileSelector();
        launchView.setVisible(true);
    }

    /**
     * Let the user to add one or more summaries from text files. It doesn't
     * throw any exception but a {@code false} value means that a summary wasn't
     * added. So, it lets the {@code view} throw an exception or not. NOTE :
     * It'll return false if just one summary wasn't added.
     *
     * @param paths an array of paths
     * @return true if every summary was added succesfully, false otherwise
     * @see #addSummary(String)
     */
    public static boolean addSummaries(String[] paths) {
        for (String p : paths) {
            if (!addSummary(p)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Just a {@code addSummaries public} method util
     *
     * @param path literally a string path
     * @return true if summary was added, false otherwise
     */
    private static boolean addSummary(String path) {
        try {
            String[] summaryString = FileController.readSummary(path);

            String title = summaryString[0];
            String[] author = summaryString[1].split(",");
            String body = summaryString[2];
            String[] keys = summaryString[3].split(",");
            Summary summary = new Summary(title, author, body, keys);

            if (summaries.get(title) == null) {
                summaries.put(title, summary);
            } else {
                return true;
            }

            for (String k : keys) {
                if (keyWords.get(k) == null) {
                    LinkedList<Summary> keySummaries = new LinkedList<>();
                    keySummaries.add(summary);
                    keyWords.put(k, keySummaries);
                } else {
                    keyWords.get(k).add(summary);
                }
            }

            for (String a : author) {
                if (authors.get(a) == null) {
                    LinkedList<Summary> authorSummaries = new LinkedList<>();
                    authorSummaries.add(summary);
                    authors.put(a, authorSummaries);
                } else {
                    authors.get(a).add(summary);
                }
            }

            return true;
        } catch (Exception e) {

        }
        return false;
    }
}
