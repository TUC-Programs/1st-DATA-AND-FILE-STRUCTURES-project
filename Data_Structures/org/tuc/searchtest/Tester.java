package org.tuc.searchtest;

import java.rmi.dgc.DGC;
import java.util.Random;

import org.tuc.Node;
import org.tuc.SearchDataStructure;
import org.tuc.counter.MultiCounter;

public abstract class Tester implements SearchDataStructure {

    private int [] numberOfNodesPerTest;
    private int failureSearches;
    private int successSearches;
    private int minIntNumber;
    private int maxIntNumber;

    public Tester(int[] numberOfNodesPerTest, int failureSearches, int successSearches, int minIntNumber,int maxIntNumber) {
        this.numberOfNodesPerTest = numberOfNodesPerTest;
        this.failureSearches = failureSearches;
        this.successSearches = successSearches;
        this.minIntNumber = minIntNumber;
        this.maxIntNumber = maxIntNumber;
    }

    private Node[] getRandomNumberNodes(int numberOfNodes){
        Node[] randomNumbers= new Node[numberOfNodes];
        Random randomGenerator=new Random();

        int [] randomInts= randomGenerator.ints(minIntNumber,maxIntNumber+1).distinct().limit(numberOfNodes).toArray();

        for(int countRandom=0; countRandom<numberOfNodes; countRandom++){
////////////////////////////////////////////////////////            
        }

        return randomNumbers;
    }

    private long[] testSuccessSearch(SearchDataStructure searchDataStructure){
        long startTime = System.nanoTime();
        long finishTime= System.nanoTime();
        int output=searchDataStructure.binarySearch();
        int keyToSearch;

        if(output!= -1){
            System.out.println("Element is in index: "+output);
        }
        else{
            System.out.println("Error...Element not found");
        }

        return null;
    }

}
