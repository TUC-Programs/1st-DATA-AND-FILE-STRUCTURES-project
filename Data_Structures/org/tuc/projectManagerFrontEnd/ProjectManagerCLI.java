package org.tuc.projectManagerFrontEnd;

import org.tuc.list.AAList;
import org.tuc.list.AList;
import org.tuc.list.DList;
import org.tuc.list.SAAList;
import org.tuc.list.SAList;
import org.tuc.list.SDList;
import org.tuc.searchtest.TestDataCollector;
import org.tuc.Globals;

public class ProjectManagerCLI {

    public static void main(String[] args) {
        TestDataCollector tdc = new TestDataCollector(); // Goes to TestDataCollector that extends to Tester (cant extend to tester because its abstract)
        for(int num : Globals.N){
            AAList aaList = new AAList();    // Start the lists
            AList aList = new AList();
            DList dList = new DList();
            SAAList saaList = new SAAList();
            SAList saList = new SAList();
            SDList sdList = new SDList();

            int[] keys = tdc.createRandomNumbers(num);           // Get key for each element and then start the insert proccess on each one
            try {
                System.out.println("Proccessing AAList ...");
                tdc.measureRunTime(aaList, keys, 'A');
                System.out.println("Proccessing AList ...");
                tdc.measureRunTime(aList, keys, 'A');
                System.out.println("Proccessing DList ...");
                tdc.measureRunTime(dList, keys, 'A');
                System.out.println("Proccessing SAAList ...");
                tdc.measureRunTime(saaList, keys, 'A');
                System.out.println("Proccessing SAList ...");
                tdc.measureRunTime(saList, keys, 'A');
                System.out.println("Proccessing SDList ...");
                tdc.measureRunTime(sdList, keys, 'A');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }


            try {                                                   // Start the delete proccess for each list
                System.out.println("Proccessing AAList ...");
                tdc.measureRunTime(aaList, keys, 'B');
                System.out.println("Proccessing AList ...");
                tdc.measureRunTime(aList, keys, 'B');
                System.out.println("Proccessing DList ...");
                tdc.measureRunTime(dList, keys, 'B');
                System.out.println("Proccessing SAAList ...");
                tdc.measureRunTime(saaList, keys, 'B');
                System.out.println("Proccessing SAList ...");
                tdc.measureRunTime(saList, keys, 'B');
                System.out.println("Proccessing SDList ...");
                tdc.measureRunTime(sdList, keys, 'B');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            

            try {                                                   // Start the search proccess for each list
                System.out.println("Proccessing AAList ...");
                tdc.measureRunTime(aaList, keys, 'C');
                System.out.println("Proccessing AList ...");
                tdc.measureRunTime(aList, keys, 'C');
                System.out.println("Proccessing DList ...");
                tdc.measureRunTime(dList, keys, 'C');
                System.out.println("Proccessing SAAList ...");
                tdc.measureRunTime(saaList, keys, 'C');
                System.out.println("Proccessing SAList ...");
                tdc.measureRunTime(saList, keys, 'C');
                System.out.println("Proccessing SDList ...");
                tdc.measureRunTime(sdList, keys, 'C');
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

    }
}
