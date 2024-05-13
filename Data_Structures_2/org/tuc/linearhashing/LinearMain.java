package org.tuc.linearhashing;

import java.io.*; 
import java.util.*; 

public class LinearMain {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		int initPages = 4, pageSize = 2, i, keysNo, searchNo, deleteNo, insertNo, searchTotal, insertTotal, deleteTotal;
	
		LinearHashing Hash1 = new LinearHashing(pageSize, initPages);
		System.out.println("Creating Linear Hash Table...."); 

		System.out.println("\nPlease enter the number of keys you wish to insert:");
		keysNo = 20;

		System.out.println( "Adding " + keysNo + " keys...");
		Random r = new Random();
		System.out.println( "KeysNum = " + Hash1.getKeysNum());
		while(Hash1.getKeysNum() < keysNo){
			Hash1.insert((r.nextInt() % 10000));
			System.out.println( "KeysNum = " + Hash1.getKeysNum());
		}
		System.out.println("done");

		Hash1.printHash();

		
		
		
		searchNo = 10000;
		boolean result;
		int search_key;
		System.out.println("Searching for " + searchNo + " random keys........");
		for (i = 1; i <= searchNo; i++){
		   search_key = (r.nextInt() % 10000);
		   result = Hash1.search(search_key);
		   if (result == true)
		     System.out.println("Search Key " + search_key + " found!!!");
		}


/*
		deleteNo = 10000;
		int delete_key;
		for(i = 1; i <= deleteNo; i++){
			delete_key = (r.nextInt() % 10000);
		       	result = Hash1.search(delete_key);
		        if (result == true) {
			  Hash1.delete(delete_key);
		          System.out.println("Key " + delete_key + " deleted!!!");
		          System.out.println( "KeysNum = " + Hash1.getKeysNum());
			}
		}
*/

	}
}

