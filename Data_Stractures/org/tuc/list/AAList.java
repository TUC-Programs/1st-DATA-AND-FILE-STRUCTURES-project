package org.tuc.list;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.Globals;

public class AAList implements List{
    private int MAX_SIZE = Globals.AAList_MaxSize;
    protected Node[] elementArray;
    protected int[] pointerArray;

    protected int tail;

    private AAList(){
        elementArray = new Node[MAX_SIZE];
        pointerArray = new int[MAX_SIZE];
        tail = -1;
        for(int i = 0; i < MAX_SIZE; i++){
            pointerArray[i] = i+1;
        }
        pointerArray[MAX_SIZE-1] = -1;
    }

    public static class  Node {
        Element element;
        int key;

        public Node(Element element, int key) {
            this.element = element;
            this.key = key;
        }
    }

    @Override
    public boolean insert(Element element){
        try{
            for (int i = 0; i < MAX_SIZE; i++) {
                if (elementArray[i] == null) {
                    elementArray[i] = new Node(element, element.getKey());
                    /* Here there should be a functionallity that changes the element
                     * before the one that was added to point into the location of the newly added element.
                    */ 
                    // Hopefully this does the trick. Note sure if i need to use it like the Node constructor.
                    break;
                }
            }
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    @Override
    public boolean delete(int key){
        try {
            for(int i = 0; i < MAX_SIZE; i++){
                if(elementArray[i].element.getKey() == key){
                    pointerArray[i] = pointerArray[i+1];
                    elementArray[i] = null;
                    
                    //for(int j = i+1; j < MAX_SIZE; j++){
                    //    pointerArray[j] = pointerArray[j+1];
                    //}
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Element search(int key){
        try {
            Element result = null; // Not sure need to look more into this

            for(int i = 0; i < MAX_SIZE; i++){
                if(elementArray[i].element.getKey() == key){
                    result = (Element) elementArray[i]; // Casting is used to convert from Node to Element. The only way i found how to make it work.
                    break;
                }
            }
            return result;

        } catch (Exception e) {
            System.err.println("Error while searching..."+e.getMessage());
            return null;
        }
    }

}
