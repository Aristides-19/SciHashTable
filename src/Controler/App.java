package Controler;

import View.FileSelector;
import model.HashTable;

/**
 *
 * @author jesus
 */
public class App {
    
    private HashTable titleTable = new HashTable (16);
    private HashTable keysTable = new HashTable (16);
    private HashTable authorsTable = new HashTable (16);
    private static double msTime;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSelector launchView = new FileSelector();
        launchView.setVisible(true);
    }
    
}
