package org.tuc.serachTest;

import org.tuc.avl.AVLTree;
import org.tuc.bst.BSTree;
import org.tuc.btree.BTree;
import org.tuc.interfaces.SearchInsert;
import org.tuc.linearhashing.LinearHashing;

public class Tester {
        // Μέθοδος για την εκτέλεση των μετρήσεων
    public void performMeasurements(int [] keys , int [] search) throws IOException {
        int N = keys.length;
        int K = getK(N);
        
        SearchInsert avlTree = new AVLTree();
        SearchInsert bstTree = new BSTree();
        SearchInsert bTree100 = new BTree(100);
        SearchInsert bTree600 = new BTree(600);
        SearchInsert linearHashing40 = new LinearHashing(40, 500);
        SearchInsert linearHashing1000 = new LinearHashing(1000, 500);

        // Εισαγωγή των κλειδιών και μέτρηση του χρόνου εισαγωγής
        long totalTimeInsertAVL = 0;
        long totalTimeInsertBST = 0;
        long totalTimeInsertBTree100 = 0;
        long totalTimeInsertBTree600 = 0;
        long totalTimeInsertLinear40 = 0;
        long totalTimeInsertLinear1000 = 0;

        for (int key : keys) {
            totalTimeInsertAVL += measureInsertTime(avlTree, key);
            totalTimeInsertBST += measureInsertTime(bstTree, key);
            totalTimeInsertBTree100 += measureInsertTime(bTree100, key);
            totalTimeInsertBTree600 += measureInsertTime(bTree600, key);
            totalTimeInsertLinear40 += measureInsertTime(linearHashing40, key);
            totalTimeInsertLinear1000 += measureInsertTime(linearHashing1000, key);
        }

        System.out.printf("N = %d%n", N);
        System.out.printf("Avarage insert time AVL: %.2f ns%n", (double) totalTimeInsertAVL / N);
        System.out.printf("Avarage insert time BST: %.2f ns%n", (double) totalTimeInsertBST / N);
        System.out.printf("Avarage insert time BTree 100: %.2f ns%n", (double) totalTimeInsertBTree100 / N);
        System.out.printf("Avarage insert time BTree 600: %.2f ns%n", (double) totalTimeInsertBTree600 / N);
        System.out.printf("Avarage insert time Linear Hashing 40: %.2f ns%n", (double) totalTimeInsertLinear40 / N);
        System.out.printf("Avarage insert time Linear Hashing 1000: %.2f ns%n", (double) totalTimeInsertLinear1000 / N);

        // Αναζήτηση τυχαίων κλειδιών και μέτρηση του χρόνου αναζήτησης και του πλήθους επιπέδων
        long totalTimeSearchAVL = 0;
        long totalTimeSearchBST = 0;
        long totalTimeSearchBTree100 = 0;
        long totalTimeSearchBTree600 = 0;
        long totalTimeSearchLinear40 = 0;
        long totalTimeSearchLinear1000 = 0;

        int totalLevelsSearchAVL = 0;
        int totalLevelsSearchBST = 0;
        int totalLevelsSearchBTree100 = 0;
        int totalLevelsSearchBTree600 = 0;
        int totalLevelsSearchLinear40 = 0;
        int totalLevelsSearchLinear1000 = 0;

        Random rand = new Random();
        for (int i = 0; i < K; i++) {
            int randomKey = rand.nextInt(3 * N) + 1;

            //totalTimeSearchAVL += measureSearchTime(avlTree, randomKey);
            //totalLevelsSearchAVL += ((AVLTree) avlTree).getLevels();

            //totalTimeSearchBST += measureSearchTime(bstTString filePath, int Nree, randomKey);
            //totalLevelsSearchBST += ((BSTree) bstTree).getLevels();

            totalTimeSearchBTree100 += measureSearchTime(bTree100, randomKey);
            totalLevelsSearchBTree100 += ((BTree) bTree100).getLevels();

            totalTimeSearchBTree600 += measureSearchTime(bTree600, randomKey);
            totalLevelsSearchBTree600 += ((BTree) bTree600).getLevels();

            //totalTimeSearchLinear40 += measureSearchTime(linearHashing40, randomKey);
            //totalLevelsSearchLinear40 += ((LinearHashing) linearHashing40).getLevels();

            //totalTimeSearchLinear1000 += measureSearchTime(linearHashing1000, randomKey);
            //totalLevelsSearchLinear1000 += ((LinearHashing) linearHashing1000).getLevels();
        }

        System.out.printf("Avarage time of search AVL: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchAVL / K, (double) totalLevelsSearchAVL / K);
        System.out.printf("Avarage time of search BST: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchBST / K, (double) totalLevelsSearchBST / K);
        System.out.printf("Avarage time of search BTree 100: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchBTree100 / K, (double) totalLevelsSearchBTree100 / K);
        System.out.printf("Avarage time of search BTree 600: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchBTree600 / K, (double) totalLevelsSearchBTree600 / K);
        System.out.printf("Avarage time of search Linear Hashing 40: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchLinear40 / K, (double) totalLevelsSearchLinear40 / K);
        System.out.printf("Avarage time of search Linear Hashing 1000: %.2f ns, Avarage number of level: %.2f%n", (double) totalTimeSearchLinear1000 / K, (double) totalLevelsSearchLinear1000 / K);
    }

    // Μέθοδος για τον υπολογισμό του K βάσει του N
    private int getK(int N) {
        if (N < 201) return 10;
        if (N < 1001) return 50;
        return 100;
    }

    // Μέθοδος για τη μέτρηση του χρόνου εισαγωγής
    private long measureInsertTime(SearchInsert structure, int key) {
        long startTime = System.nanoTime();
        structure.insert(key);
        return System.nanoTime() - startTime;
    }

    // Μέθοδος για τη μέτρηση του χρόνου αναζήτησης
    private long measureSearchTime(SearchInsert structure, int key) {
        long startTime = System.nanoTime();
        structure.searchKey(key);
        return System.nanoTime() - startTime;
    }
    

}
