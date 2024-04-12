package org.tuc.list;

import org.tuc.Element;

public class SAList extends AList{

   
    

    private int size;
    //private int tail;
    private Element[] elements;

    public SAList(){
        super();
        this.elements=new Element[size];
        this.size=0;
        //this.tail=0;

    }



    @Override
    public boolean insert(Element element){
        //check if we not have enough capasity to put elements
        if(size == elements.length){
            createSpace();
        }

        int index = binarySearch(element.getKey());

        if(index<0){
            index =-(index-1);
        }

        //move elements to the right
        for(int i=size; i>index; i-- ){
            elements[i]=elements[i-1];
        }

        //inser the new element
        elements[index]=element;
        size++;

        return true;

    }


    @Override
    public boolean delete(int key){
        int index= binarySearch(key);

       
        if(index<0){
            return false;
        }

        for(int i= index; i<size-1; i++){
            elements[i]=elements[i+1];
        }

        elements[size-1]=null;

        return true;
    }

    @Override
    public Element search(int key){
        int index= binarySearch(key);

        if(index<0){
            return null;
        }

        return elements[index];
    }

    
    private int binarySearch(int key){
        int left=0;
        int right= size-1;

        while (left<=right){
            int mid= left + (right-left)/2;

            if(elements[mid].getKey() == key){
                return mid;
            }
            else if(elements[mid].getKey()<key){
                left =mid +1;
            }
            else{
                right=mid-1;
            }
        }
        return -(left +1);
    }

    // function to increase the capasity when the capasity is full and we want to put an other element
    private void createSpace(){
        Element [] newElm= new Element[elements.length*2];

        for(int i=0; i< size; i++){
            newElm[i]=elements[i];
        }
        elements=newElm;
    }


}
