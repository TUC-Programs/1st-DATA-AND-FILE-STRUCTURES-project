package org.tuc.interfaces;

public interface SearchInsert {

    /**
    * Inserts key into the data structure
    * @param key
    */public void insert(int key);
    /**
    * Searches for given key.
    * @param key
    * @return true if key is found, false otherwise
    */
    public boolean searchKey(int key);
        
    

}
