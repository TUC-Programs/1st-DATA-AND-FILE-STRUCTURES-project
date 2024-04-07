package org.tuc.list;

import org.tuc.Element;

public class SAAList extends AAList {
    public SAAList(){
        super();
    }

    @Override
    public boolean insert(Element element){
        try{
            if(nextfree1 == -1){
                System.out.println("The List is full !");
                return false;
            }

            int index = nextfree1;  //index = 0 nextfree1 = 0   |     index = 1                    
            elementArray[index] = new MyElement(element, element.getKey());                      // Adding the current element to the next free position that we have
            nextfree1 = pointerArray[nextfree1];            // Getting the pointer of the recently added pointer for the next position
            //nextfree1 = 1 | nextfree1 = 2
            
            if(length == 1){
                head1 = index; //head = 0
                tail1 = index;
                return true;
            }

            if(length > 1){
                for(int i = 0; i < length-1; i++){
                    for(int j = i; j < length; j++){
                        if(elementArray[i].element.getKey() > elementArray[j].element.getKey()){
                            pointerArray[j] = i;
                        }else if(elementArray[i].element.getKey() < elementArray[j].element.getKey()){
                            pointerArray[j] = pointerArray[i];
                            pointerArray[i] = j;
                        }
                    }
                }
                for(int i = 0; i < length; i++){
                    if(elementArray[i].element.getKey() > elementArray[tail1].element.getKey()){
                        tail1 = i;
                        pointerArray[i] = -1;
                    }
                    if(elementArray[i].element.getKey() < elementArray[tail1].element.getKey()){
                        head1 = i;
                    }
                }
            }

            if(elementArray.length == 10){                  // Set next open slot to -1 when array is full
                nextfree1 = -1;
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
                    elementArray[i] = null;                         //Deletes the requested element
                    nextfree1 = i;                                  //Sets the next free position to be the one where the element got deleted
                    
                    if(head1 == i){                                 //When the head of the list is deleted
                        head1 = pointerArray[i];
                    }else if(tail1 == i){                           //When the tail of the list is deleted
                        for(int j = 0; j < MAX_SIZE; j++){          //Searching for the pointer to the tail
                            if(pointerArray[j] == i){
                                tail1 = j;                          //Sets the index num as the new tail
                                pointerArray[j] = -1;               //Sets the pointer of the new tail to -1
                            }
                        }
                    }else{
                        for(int j = 0; j < MAX_SIZE; j++){          //Searching for the previous element
                            if(pointerArray[j] == i){
                                pointerArray[j] = pointerArray[i];  //Sets the previous element pointer to point at the next element
                            }
                        }
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
            int result = 1;
            for(int i = 0; i < MAX_SIZE; i++){
                if(elementArray[i].element.getKey() == key){
                    return elementArray[i].element;
                }
                result = -1;
            }
            if(result == -1){
                System.out.println("The Element was not found in the list!");
            }
            return null;
        } catch (Exception e) {
            System.err.println("Error while searching..."+e.getMessage());
            return null;
        }
        
    }
}
