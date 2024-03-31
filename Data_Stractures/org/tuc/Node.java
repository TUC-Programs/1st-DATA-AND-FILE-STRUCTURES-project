package org.tuc;

public interface Node extends Element {
   /*
     * See again if i can do with different way to not trow error in the 
     * class AList when i write myArray[i].getKey()
     * 
     */
    
    //This work but i do not know if i can use it
     int getKey();
    Object getElement();
    void setElement(Object element);
}
