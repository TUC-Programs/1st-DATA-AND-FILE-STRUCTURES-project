package org.tuc.readFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.tuc.globals.Globals;

public class ReadKey {


    /*
    public static int [] readKeysFromFile(String fName){
        List<Integer> keys = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fName))){
            String line;

            while ((line = reader.readLine()) != null){
                String [] keyStr = line.split(",");

                for( String key : keyStr){
                    keys.add(Integer.parseInt(key.trim()));
                }
            }
        }catch (Exception e) {
            System.out.println("Error reading from file "+ e.getMessage());
        }

        return keys.stream().mapToInt(i -> i).toArray();
    }
*/
}
