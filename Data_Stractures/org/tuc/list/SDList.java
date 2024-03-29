package org.tuc.list;

import org.tuc.Element;

public class SDList extends DList{

    @Override
    public boolean insert(Element element){
        try{
            Node newNode =new Node(element, size, tail, head);
        
            //check if the list is empty or the firt element is smaller than first
            if (isEmpty() || element.getKey() < head.element.getKey()) {
                newNode.next = head;
                head = newNode;
                size++;
                return true;
            } else {
                Node present = head;

                // find the insertion position
                while (present.next != null && element.getKey() > present.next.element.getKey()) {
                    present = present.next;
                }

                // insert the element
                newNode.next = newNode;
                size++;
                return true;
            }

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
