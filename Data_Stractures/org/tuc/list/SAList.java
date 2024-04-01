package org.tuc.list;

import org.tuc.Element;
import org.tuc.binarysearchnode.Binarysearch;

public class SAList extends AList{

    private int size;
    private int tail;
    private Element[] elements;

    protected SAList(){
        this.elements=new Element[size];
        this.size=0;
        this.tail=0;

    }


    /*
     * TO DO
     * binarySearch code and this class is ready
     * 
     */

    @Override
    public boolean insert(Element element){
        if(size == elements.length){
            bindCapasity();
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
        int idex= binarySearch(key);

        if(index<0){
            return false;
        }

        for(int i= index; i<size-1; i++){
            elements[i]=elements[i+1];
        }

        elements[size-1]=null

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


    private void bindCapasity(){

        int newCap= elements.length*2;
        Element [] newElements= new Element[newCap];

        for(int i =0; i<size; i++){
            newElements[i]= elements[i];
        }

        elements= newElements;
    }

}
