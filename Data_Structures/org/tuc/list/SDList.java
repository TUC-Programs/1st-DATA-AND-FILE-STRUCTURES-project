package org.tuc.list;

import org.tuc.Element;
import org.tuc.Node;

public class SDList extends DList{

    @Override
    public boolean insert(Element element){
        try{
            int key =element.getKey();
            Node newNode = new Node(null,key);
            
            if(isEmpty()){
                head=newNode;
                tail=newNode;
            }
            else{
                Node present =head;
                Node previous = null;

                while (present !=null && present.getKey()< key) {
                    previous=present;
                    present=present.next;
                }
                if(previous == null){
                    head.previous= newNode;
                    newNode.next=head;
                    head=newNode;
                }
                else if(present == null){
                    tail.next=newNode;
                    newNode.previous=tail;
                    tail= newNode;
                }
                else{
                    previous.next=newNode;
                    newNode.previous=previous;
                    newNode.next=present;
                    present.previous=newNode;
                }

            }
            return true;
            
        } catch (Exception ex) {
            System.err.println("Error during insertio..." + ex.getMessage());
            return false;
        }
    }

    private boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

}
