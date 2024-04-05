package org.tuc;


public class Node{

    public Element element;
    public Node next;
    public Node tail;
    public Node head;
    public Node previous;
    int key;
    

    public Node(int key){
        this.key= key;
    }


    public Element getElement() {
        return element;
    }


    public void setElement(Element element) {
        this.element = element;
    }


    public Node getPrevious() {
        return previous;
    }


    public void setPrevious(Node previous) {
        this.previous = previous;
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
