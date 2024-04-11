package org.tuc.projectManagerFrontEnd;

import org.tuc.list.AAList;
import org.tuc.list.AList;
import org.tuc.list.DList;
import org.tuc.list.SAAList;
import org.tuc.list.SAList;
import org.tuc.list.SDList;
import org.tuc.searchtest.TestDataCollector;

public class ProjectManagerCLI {

    /**
	 * The maximum generated number used as key for the nodes
	 */
	static int MAX_INT_NUMBER = 100000000;
	
	/**
	 * The minimum generated number used as key for the nodes
	 */	
	static int MIN_INT_NUMBER = -100000000;
	
	/**
	 * The amount of successful search, i.e. searches for keys that are in the data set
	 */
	static int SUCCESS_SEARCHES = 100;
	
	
	/**
	 * The amount of failure search, i.e. searches for keys that are not in the data set
	 */
	static int FAILURE_SEARCHES = 100;
	
	/**
	 * The test is run for different amount of keys in the data set, given by this array 
	 */
	static int N[] = { 30, 50, 100, 200, 500, 1000, 5000, 10000, 100000};

    public static void main(String[] args) {
        TestDataCollector tdc = new TestDataCollector();
        for(int num : N){
            AAList aaList = new AAList();
            AList aList = new AList();
            DList dList = new DList();
            SAAList saaList = new SAAList();
            SAList saList = new SAList();
            SDList sdList = new SDList();

            int[] keys = tdc.createRandomNumbers(N[num]);
            try {
                System.out.println("Proccessing AAList ...");
                tdc.measureRunTime(aaList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println("Proccessing AList ...");
                tdc.measureRunTime(aList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println("Proccessing DList ...");
                tdc.measureRunTime(dList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println("Proccessing SAAList ...");
                tdc.measureRunTime(saaList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println("Proccessing SAList ...");
                tdc.measureRunTime(saList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println("Proccessing SDList ...");
                tdc.measureRunTime(sdList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
