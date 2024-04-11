package org.tuc.searchtest;


import org.tuc.List;
import java.util.Random;
import org.tuc.Globals;
import org.tuc.MyElement;

public abstract class Tester {


    public int[] createRandomNumbers(){
        
        int[] num = new int[Globals.N];
        Random r = new Random();
        for(int i=0; i<Globals.N; i++){
            num[i]=r.nextInt(2*Globals.N+1);
        }

        return num;
    }

    public void measureRunTime(List list, int[] keys, char choise){

        char choose = Character.toLowerCase(choise); //here covert in lower case the user input to take correct both a and A 
        long startTime= System.nanoTime();
        int assigns =0;  //number of assigments 
        int comparissons=0; //number of comparissons

        switch (choose) {
            case 'A':

                for(int i=0; i< keys.length; i++){     //for loop to put the elements
                    MyElement e= new MyElement(i);
                    list.insert(e);
                } 
                break;
            
            case 'B':
                Random r = new Random();                  
                int [] rkeys= createRandomNumbers();   //here i call the above method to create random keys
                int keyIndex= r.nextInt(keys.length); //here i find the index of array for the key which will be deleted
                int deletekey= rkeys[keyIndex];       // put the key in a variable
                list.delete(deletekey);               //delet the key with the using of method delte whitch contained in the 6 lists

                break;
        
            case 'C':

                Random ra = new Random();                  
                int [] rakeys= createRandomNumbers();   
                int keyindex= ra.nextInt(keys.length); 
                int searchkey= rakeys[keyindex];       
                list.delete(searchkey);               //search the key with the using of method search whitch contained in the 6 lists

                break;   
            
            default:
                System.out.println("Wrong choise...Try again select A,B,C.");
                break;
        }

        long endTime= System.nanoTime();
        long runtime= endTime-startTime;

        System.out.println("Total comparissons is: "+comparissons);
        System.out.println("Total assigns is: "+assigns);
        System.out.println("The runtime is: "+runtime);
    }
    
 
    /*TO DO
     * Το πείραμα αποτελείται από τα παρακάτω βήματα, τα οποία θα επαναληφθούν για πλήθος
        στοιχείων N=30, 50, 100, 200, 500, 800, 1.000, 5.000, 10.000, 100.000 (τυχαία κλειδιά κάθε
        φορά)
        1) Προετοιμασία
        a) δημιουργείτε ένα νέο στιγμιότυπο για κάθε μία από τις 6 υλοποιήσεις σας
        b) δημιουργείτε N τυχαίους αριθμούς (μη ταξινομημένους!) με τιμές από 1 έως 2*N
        και τους αποθηκεύετε σε ένα απλό array
        c) για κάθε έναν από τους N τυχαίους αριθμούς, δημιουργείτε ένα στιγμιότυπο
        Element και το εισάγετε σε κάθε μία από τις 6 δομές σας
        
     * 2) Μετρήσεις
        a) παράγετε K* τυχαίους αριθμούς από 1 έως 2*N (δε χρειάζεται να είναι μοναδικοί).
        Για κάθε έναν εκτελείτε τη λειτουργία Α σε κάθε μία από τις 6 δομές σας.
        Καταγράφετε κάθε φορά το χρόνο εκτέλεσης σε nanosecond και το πλήθος
        πράξεων. Από τις K* εκτελέσεις της λειτουργίας Α, θα πάρετε το μέσο όρο του
        χρόνου εκτέλεσης και το μέσο όρο των πράξεων για μία εκτέλεση της
        λειτουργίας Α. Χρησιμοποιήστε 2 δεκαδικά ψηφία για τους μέσους όρους.*
        K=10 όταν N < 201
        K=50 όταν Ν > 200 και Ν < 1001
        Κ=100 όταν Ν > 1000
        b) το ίδιο με το a) αλλά για τη λειτουργία B
        c) το ίδιο με το a) αλλά για τη λειτουργία Γ
     * 
     */




    
    
    




}
