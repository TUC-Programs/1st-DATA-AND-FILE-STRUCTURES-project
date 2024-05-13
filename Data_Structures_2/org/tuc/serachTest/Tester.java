package org.tuc.serachTest;

import org.tuc.avl.AVLTree;
import org.tuc.bst.BSTree;
import org.tuc.btree.BTree;
import org.tuc.interfaces.SearchInsert;
import org.tuc.linearhashing.LinearHashing;

public class Tester {

    private AVLTree avlTree;
    private BSTree bsTree;
    private BTree bTree1001;
    private BTree bTree600;
    private LinearHashing linear40;
    private LinearHashing linear1000;

    public Tester() {
        this.avlTree = new AVLTree();
        this.bsTree = new BSTree();
        this.bTree1001 = new BTree(1001); // Assuming this is the max keys per node
        this.bTree600 = new BTree(600);  // Same here for max keys per node
        this.linear40 = new LinearHashing(40, 500);
        this.linear1000 = new LinearHashing(1000, 500);
    }

    public void runExperiments(int[] keys, int[] searchKeys) {
        // Insert keys and measure insertion times
        measureInsertionTimes(keys);

        // Search for keys and measure search times and levels
    }

    private void measureInsertionTimes(int[] keys) {
        System.out.println("Measuring Insertion Times");

        long startTime = System.nanoTime();
        for (int key : keys) {
            avlTree.insert(key);
        }
        long endTime = System.nanoTime();
        System.out.println("AVL Tree Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");

        startTime = System.nanoTime();
        for (int key : keys) {
            bsTree.insert(key);
        }
        endTime = System.nanoTime();
        System.out.println("BSTree Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");

        startTime = System.nanoTime();
        for (int key : keys) {
            bTree1001.insert(key);
        }
        endTime = System.nanoTime();
        System.out.println("BTree1001 Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");

        startTime = System.nanoTime();
        for (int key : keys) {
            bTree600.insert(key);
        }
        endTime = System.nanoTime();
        System.out.println("BTree600 Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");

        startTime = System.nanoTime();
        for (int key : keys) {
            linear40.insert(key);
        }
        endTime = System.nanoTime();
        System.out.println("Linear40 Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");

        startTime = System.nanoTime();
        for (int key : keys) {
            linear1000.insert(key);
        }
        endTime = System.nanoTime();
        System.out.println("Linear1000 Insertion Time: " + (endTime - startTime) / keys.length + " ns per insertion");
    }

    






    /*AVLTree avlTree = new AVLTree();
    BSTree bsTree = new BSTree();
    BTree bTree1 = new BTree(50);
    BTree bTree2 = new BTree(300);
    LinearHashing linearHashing1 = new LinearHashing(40,500 );
    LinearHashing linearHashing2 = new LinearHashing(1000,500 );


    public static void insertTesting( SearchInsert str, int [] keys){
        long beginTime = System.nanoTime();
        for (int i = 0; i < keys.length; i++){
            str.insert(i);
        }
        long finishTime = System.nanoTime();
        long durTime = (finishTime - beginTime)/ keys.length;
        System.out.println("Insert mean time "+durTime+"ns");
    }


    public static void searchTesting( SearchInsert str, int [] keys){
        long tSearchTime = 0;
        long tLevelTrees = 0;

        for(int i=0; i < keys.length; i++){
            long beginTime = System.nanoTime();
            boolean find = str.searchKey(i);
            long finishTime = System.nanoTime();
            tSearchTime += (finishTime - beginTime);

            //here the code to calculate the total Level of each tree
        
            if(str instanceof AVLTree){
                int levels = ((AVLTree) str).getSearchKey(i);
                tLevelTrees += levels;
            }
        
        
        }

        long avergSearchTime = tSearchTime / keys.length;

        System.out.println("Search mean time "+avergSearchTime+"ns");
        System.out.println("Level of nodes "+tLevelTrees);
    }


     // Find the number of repeat for each node number
     public static int RepeatTestCalc(int size){
        int K;
        if(size<201){
            K=10;
        }else if(size<1001){
            K=50;
        }else{
            K=100;
        }
        return K;
    }*/

}
