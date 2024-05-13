package org.tuc.frontEndMain;

import java.util.Random;

import org.tuc.avl.AVLTree;
import org.tuc.bst.BSTree;
import org.tuc.btree.BTree;
import org.tuc.linearhashing.LinearHashing;
import org.tuc.serachTest.Tester;

public class AdminCluster {

    public static void main(String[] args) {


        AVLTree avlTree = new AVLTree();
        BSTree bsTree = new BSTree();
        BTree bTree = new BTree(5);
        LinearHashing linearHashing = new LinearHashing(100,10 );
        
        Tester tester = new Tester();
        Random random = new Random();
        int[] keys = random.ints(1000, 0, 50000).toArray();
        int[] searchKeys = random.ints(1000, 0, 50000).toArray();
        tester.runExperiments(keys, searchKeys);
    }
}
