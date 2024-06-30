package Model;

/**
 *
 * @author jesus
 */
public class TableHash {
    
    private Nodo[] table;
    private int capacity;
    
    public TableHash(int capacity) {
        this.capacity = capacity;
        table = new Nodo[capacity];
    }
    
    public int hashing1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
                hash += (key.charAt(i) * Math.pow(29, key.length() - (i+1)));
        }
        hash = hash % capacity;
        return hash;
    }
    
    public int hashing2(String key) {
        String[] letter = key.split("");
        int hash = 0;
        for(int i=0; i<letter.length; i++){
            hash += (i+1)*(Math.pow(29,((letter.length)>>1)-1));
        }
        hash = hash % capacity;
        return hash;
    }
    
    
}
