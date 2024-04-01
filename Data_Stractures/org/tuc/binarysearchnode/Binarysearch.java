package org.tuc.binarysearchnode;

import java.util.Random;

import javax.swing.text.html.parser.Element;

import org.tuc.Node;
import org.tuc.SearchDataStructure;
import org.tuc.counter.MultiCounter;

public class Binarysearch implements SearchDataStructure{
    /*
    public int binarySearch(int key){
        private Node [] array;
        int first,last;

        int mid = (first + last)/2;  
        while( first <= last ){  
            if ( array[mid] < key ){  
                first = mid + 1;     
            }else if ( array[mid] == key ){  
                System.out.println("Element is found at index: " + mid);  
                break;  
            }else{  
                last = mid - 1;  
            }  
            mid = (first + last)/2;  
        }  
        if ( first > last ){  
            System.out.println("Element is not found!");  
        }  
 }  */
 
    private Node data[];

	/**
	 * Constructor. Given newData must be sorted!
	 * @param newData
	 */
	public Binarysearch(Node newData[]) {
		this.data = newData;
	}
	
	/**
	 * Given newData must be sorted!
	 * @param newData
	 */
	public void setData(Node newData[]) {
		this.data = newData;
	}
	
	@Override
	public Node search(int key) {
		if (data == null) {
			return null;
		}
		return doSearch(0, data.length - 1, key);
	}
	

	/**
	 * <p>
	 * Helper method that searches in data array, from index leftIndex to index rightIndex. 
	 * Uses recursion
	 * </p>
	 * 
	 * @param leftIndex   The left index of the data array
	 * @param rightIndex  The right index of the data array
	 * @param key         The key to search
	 * @return            The node containing the key if found
	 */
	private Node doSearch(int leftIndex, int rightIndex, int key) 
    { 
		MultiCounter.increaseCounter(2);

		
        if (MultiCounter.increaseCounter(1) && rightIndex >= leftIndex) { 
        	MultiCounter.increaseCounter(1);
            int mid = leftIndex + (rightIndex - leftIndex) / 2; 
  
            // Check if the middle is the key we search for 
            if (MultiCounter.increaseCounter(1) && data[mid].getKey() == key) 
                return data[mid]; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (MultiCounter.increaseCounter(1) && data[mid].getKey() > key) 
                return doSearch(leftIndex, mid - 1, key); 
  
            // Else the element can only be present 
            // in right subarray 
            return doSearch(mid + 1, rightIndex, key); 
        } 
  
        // We reach this location when element is not present in array 
        return null; 
    }

	
	// START TODO: it seams that methods getRandomExistingKey and getRandomNonExistingKey are exactly the same
	// as used in ArraySearch. Should add them to an abstract superclass of both classes
	@Override
	public int getRandomExistingKey() {
		Random random = new Random();
		return data[random.nextInt(data.length)].getKey();
	}

	@Override
	public int getRandomNonExistingKey(int maxIntNumber, int minIntNumber) {
		// generate random keys in valid range until we find one that does not exist 
		Node found = null;
		Random random = new Random();
		int keyToSearch;
		do {
			keyToSearch = random.nextInt(maxIntNumber-minIntNumber) + minIntNumber;
			found = this.search(keyToSearch);
		} while (found != null);
		
		return keyToSearch;
	} 


    /*
     * TO DO
     * Check which of the above need in the project
     * 
     * 
     * 
     * 
     */
    
    

}
