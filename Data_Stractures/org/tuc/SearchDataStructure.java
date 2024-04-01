package org.tuc;

public interface SearchDataStructure {

    /**
	 * Search for a node with given key and returns it if found.
	 * @param key
	 * @return the node with given key
	 */
	public Node search(int key);
	
	/**
	 * 
	 * @return a random Key in the data structure. Used only for testing
	 */
	public int getRandomExistingKey();
	


	/**
	 * 
	 * @param maxIntNumber
	 * @param minIntNumber
	 * @return a random Key that does not exist in the data structure. Used only for testing
	 */
	public int getRandomNonExistingKey(int maxIntNumber, int minIntNumber);

}
