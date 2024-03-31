package org.tuc.list;

import org.tuc.Element;
import org.tuc.List;

public class AAList implements List{
    private static final int MAX_SIZE = 10;
    protected Node[][] array;
    protected int tail;
    protected int next;

    private AAList(){
        array = new Node[MAX_SIZE][2];
        tail = -1;
    }

    public static class  Node {
        Element element;
        int key;
        Node next;
        Node previous;

        public Node(Element element, int key) {
            this.element = element;
            this.key = key;
            //this.next = next;
            //this.previous=previous;
        }

    }

    @Override
    public boolean insert(Element element){
        try{
            if(tail == MAX_SIZE){
                System.out.println("List is full !");
                return false;
            }
            for (int i = 0; i < MAX_SIZE; i++) {
                if (array[i][0] == null) {
                    array[i][0] = new Node(element, element.getKey());
                    array[i][1] = new Node(null, tail);
                    /* Here there should be a functionallity that changes the element
                     * before the one that was added to point into the location of the newly added element.
                    */ 
                    array[i-1][1] = new Node(null, i); // Hopefully this does the trick. Note sure if i need to use it like the Node constructor.
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
                if(array[i][0].element.getKey() == key){
                    array[i][0] = null;
                    array[i][1] = new Node(null, -1);
                    
                    for(int j = 0; j < MAX_SIZE; j++){
                        array[j][0] = array[j-1][0];
                    }
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
                if(array[i][0].element.getKey() == key){
                    result = (Element) array[i][0]; // Casting is used to convert from Node to Element. The only way i found how to make it work.
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
