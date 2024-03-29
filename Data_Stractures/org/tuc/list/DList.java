package org.tuc.list;

import org.tuc.Element;
import org.tuc.List;

public class DList implements List{

    protected Node head;
    protected Node tail;
    protected int size;

    public static class  Node {
        Element element;
        int key;
        Node next;
        Node previous;

        public Node(Element element, int key, Node next, Node previous) {
            this.element = element;
            this.key = key;
            this.next = next;
            this.previous=previous;
        }

    }

    
    @Override
    public boolean insert(Element element){
        try{

            Node newNode= new Node(element, element.getKey(), tail, head);
            
            if(head==null){
                head=newNode;
                tail= newNode;
            }
            else{
                tail.next=newNode;
                newNode.previous=tail;
                tail.next=newNode;
            }

            
            size++;

            return true;

        }catch(Exception ex){
            return false;
        }
    }


    @Override
    public boolean delete(int key) {
        
        try{

            Node present =head;

            if(head==null){
                return false;
            }
            else if(present.key==key){
                present= present.next;

                if(present!=null){
                    present.previous=null;
                }
                else{
                    tail=null;
                }

                size--;
                return true;

            }

            

            while(present.next!= null){
                if(present.next.key==key){
                    if(present.next.next == null){
                        tail= present;
                    }
                    else{
                        present.next.next.previous = present;
                    }
                    present.next=present.next.next;
                    size--;
                    return true;                  
                }
                present =present.next;
            }

            return false; //key not found


        }catch (Exception ex){
            return false;
        }
    }


    @Override
    public Element search(int key) {
        
        try{
            Node present =head;

            while(present!=null){
                if(present.key ==key){
                    return present.element;
                }
                present =present.next;
            }
            //TO DO check if i can delete this command
            throw new RuntimeException("Element with key "+key+" not found"); // if I deleted this command throw error

        }catch(Exception ex){

            System.err.println("Error while searching..."+ex.getMessage());
            return null;
        }
        
    }

}

