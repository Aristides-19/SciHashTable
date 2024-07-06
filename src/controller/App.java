package controller;

import View.FileSelector;
import model.HashTable;
import model.Summary;

/**
 *
 * @author jesus
 */
public class App {
    
    private HashTable<String, Summary> summaries = new HashTable<>(16);
    private HashTable<String, Summary> keyWords = new HashTable<>(16);
    private HashTable<String, Summary> authors = new HashTable<>(16);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSelector launchView = new FileSelector();
        launchView.setVisible(true);
    }
    
}
