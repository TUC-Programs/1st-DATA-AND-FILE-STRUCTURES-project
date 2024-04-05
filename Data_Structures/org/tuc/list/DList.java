package org.tuc.list;


import org.tuc.Element;
import org.tuc.List;
import org.tuc.Node;

public class DList implements List{

    protected Node head;
    protected Node tail;
    protected int size;

    @Override
    public boolean insert(Element element){
        try{

            Node newNode= new Node(element.getKey());
            
            if(head==null){
                head=newNode;
                tail= newNode;
            }
            else{
                tail.setNext(newNode);
                tail=newNode;
            }

            return true;

        }catch(Exception ex){
            return false;
        }
    }


    @Override
    public boolean delete(int key) {
        
        try{
            if(head==null){
                return false;
            }
            else if(head.getKey()==key){
                head= head.getNext();

                if(head== null){
                    tail=null;
                }
                return true;

            }

            Node present=head;

            while(present.getNext()!= null){
                if(present.getNext().getKey()==key){

                    present.setNext(present.getNext().getNext());

                    if(present.getNext() == null){
                        tail= present;
                    }

                    return true;                  
                }
                present =present.getNext();
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

            while(head!=null){
                if(present.getKey() == key){
                    return present.element;
                }
                present =present.getNext();
            }
            return null;

        }catch(Exception ex){

            System.err.println("Error while searching..."+ex.getMessage());
            return null;
        }
        
    }

}

