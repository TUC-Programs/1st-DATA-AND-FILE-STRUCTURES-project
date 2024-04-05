package org.tuc;

import org.tuc.Element;

public class Node{

    public Element element;
    public Node next;
    public Node previous;
    int key;

    public Node(int key){
        this.key= key;
    }
    

    public Node(Element element,int key){
        this.key=key;
        this.element=element;
    }



    //Getters and Setters 
    public int getKey() {
        return key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
