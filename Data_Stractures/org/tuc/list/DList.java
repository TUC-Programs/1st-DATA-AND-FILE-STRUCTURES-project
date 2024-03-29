package org.tuc.list;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List{

    public static class  Node {
        Element element;
        int key;
        Node next;

        public Node(Element element, int key, Node next) {
            this.element = element;
            this.key = key;
            this.next = next;
        }

    }

    private Node head;
    private Node tail;
    private int size;
    
    @Override
    public boolean insert(Element element){
        
        
        return true;
    }


    @Override
    public boolean delete(int key) {
        return true;
    }


    @Override
    public Element search(int key) {
        return null;
        
    }

}

