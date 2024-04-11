package org.tuc;

public class Globals {

    public static final int numCounter = 10;
    public static final int AAList_MaxSize = 10;

    /**
	 * The maximum generated number used as key for the nodes
	 */
	public static final int MAX_INT_NUMBER = 100000000;
	
	/**
	 * The minimum generated number used as key for the nodes
	 */	
	public static final int MIN_INT_NUMBER = -100000000;
	
	/**
	 * The amount of successful search, i.e. searches for keys that are in the data set
	 */
	public static final int SUCCESS_SEARCHES = 100;
	
	/**
	 * The amount of failure search, i.e. searches for keys that are not in the data set
	 */
	public static final int FAILURE_SEARCHES = 100;
	
	/**
	 * The test is run for different amount of keys in the data set, given by this array 
	 */
	public static final int N[] = { 30, 50, 100, 200, 500, 1000, 5000, 10000, 100000};
}
