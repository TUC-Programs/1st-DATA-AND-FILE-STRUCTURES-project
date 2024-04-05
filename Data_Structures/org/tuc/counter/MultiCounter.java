package org.tuc.counter;

import org.tuc.Globals;


public class MultiCounter {
	
    /**
	 * Default constructor
	 */
	public MultiCounter() {
		
	}
	
	/**
	 * variable holding our counters. We support up to 10 counters
	 */
	private static long[] counters = new long[Globals.numCounter];


	/**
	 * Resets the internal counter of counterIndex to zero
	 * @param counterIndex The counter to reset
	 */
	public static void resetCounter(int counterIndex) {
		if (counterIndex-1 < counters.length)
			counters[counterIndex-1] = 0;
	}

	/**
	 * Returns the current count for given counterIndex
	 * 
	 * @param counterIndex The counter to return
	 * @return the current count for given counterIndex
	 */
	public static long getCount(int counterIndex) {
		if (counterIndex-1 < counters.length)
			return counters[counterIndex-1];
		return -1;
	}

	/**
	 * Increases the current count of counterIndex by 1. Returns always true so that it can be used
	 * in boolean statements
	 * 
	 * @param counterIndex The counter to modify
	 * @return
	 */
	public static boolean increaseCounter(int counterIndex) {
		if (counterIndex-1 < counters.length)
			counters[counterIndex-1]++;
		return true;
	}

	/**
	 * Increases the current count of counter given by counterIndex by step. Returns always true so that it can be
	 * used in boolean statements. Step could be negative. It is up to the specific
	 * usage scenario whether this is desirable or not.
	 * 
	 * @param counterIndex The counter to modify
	 * @param step The amount to increase the counter
	 * @return always true
	 */
	public static boolean increaseCounter(int counterIndex, int step) {
		if (counterIndex-1 < counters.length)
			counters[counterIndex-1] = counters[counterIndex-1] + step;
		return true;
	}

}
