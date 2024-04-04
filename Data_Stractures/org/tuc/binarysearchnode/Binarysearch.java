package org.tuc.binarysearchnode;

import org.tuc.Node;

public class Binarysearch{

	private Node [] array;
	private int first, last;

	/**
	 * Constructor. Given newData must be sorted!
	 * @param newData
	 */
	public Binarysearch(Node array[], int first, int last) {
		this.array=array;
		this.first=first;
		this.last=last;
	}
    
    public int binarySearch(int key){

        while( first <= last ){  
		    int mid = (first + last)/2;  
            if ( array[mid].getKey() < key ){  
                first = mid + 1;     
            }else if ( array[mid].getKey() == key ){  
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
		return key;  
 	}  
 
    
    

}
