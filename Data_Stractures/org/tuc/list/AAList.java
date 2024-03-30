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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Element search(int key){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
