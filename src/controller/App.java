package controller;

import java.util.LinkedList;
import view.FileSelector;
import model.HashTable;
import model.Summary;

/**
 *
 * @author jesus
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
     * Bridge to send path of the file to read from view
     *
     * @param path path of the file txt
     * @return true if the process was succesful, false otherwise
     */
    public static boolean sendFilePath(String path) {
        try {
            String[] summaryString = FileController.readSummary(path);
            
            String title = summaryString[0];
            String[] authorss = summaryString[1].split(",");
            String body = summaryString[3];
            String[] keys = summaryString[3].split(",");
            Summary summary = new Summary (title, authorss, body, keys);

            summaries.put(title, summary);
            
            for(String key: keys){
                if (keyWords.get(key)==null){
                    LinkedList<Summary> summariesOfKey = new LinkedList<>();
                    summariesOfKey.add(summary);
                    keyWords.put(key, summariesOfKey);
                }
                else{
                    keyWords.get(key).add(summary);
                }
            }
            
            for(String author: authorss){
                if (keyWords.get(author)==null){
                    LinkedList<Summary> summariesOfAuthor = new LinkedList<>();
                    summariesOfAuthor.add(summary);
                    keyWords.put(author, summariesOfAuthor);
                }
                else{
                    keyWords.get(author).add(summary);
                }
            }

            return true;
        } catch (Exception e) {

        }
        return false;
    }
}
