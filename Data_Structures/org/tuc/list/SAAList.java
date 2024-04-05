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

            // This is more correct than the one below it
            if(length > 1){
                for(int i = 0; i < length; i++){
                    for(int j = 0; j < length; j++){
                        if(elementArray[i].element.getKey() > elementArray[j].element.getKey()){
                            pointerArray[j] = i;
                            head1 = j;
                        }else if(elementArray[i].element.getKey() < elementArray[j].element.getKey()){
                            pointerArray[j] = pointerArray[i];
                            pointerArray[i] = j;
                            head1 = i;
                        }
                    }
                }
            }


            // The one above is better
            for(int i = 0; i < length; i++){
                for(int j = 0; j < length; j++){
                    if(elementArray[i].element.getKey() > elementArray[j].element.getKey()){
                        pointerArray[j] = i;
                        head1 = j;
                    }else{
                        pointerArray[j] = pointerArray[i];
                        pointerArray[i] = j;
                        head1 = i;
                    }
                }
            }

            //for(int i = 1; i < MAX_SIZE-1; i++){                  // Sets the new tail element and restores the previous tail the pointer
            //    if(elementArray[i].element.getKey() > elementArray[i-1].element.getKey()){ // 8>4
            //        pointerArray[i] = -1; // [8  -1]
            //        pointerArray[i-1] = i;   //[4   1]
            //        tail1 = i; //tail1 = 0 | tail1 =1
            //    }else{//4  8
            //        pointerArray[i] = i-1;
            //        if(elementArray[tail1].element.getKey() < elementArray[i].element.getKey()){
            //            pointerArray[i-1] = -1;
            //            tail1 = i-1;
            //        }
            //    }
            //}

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
