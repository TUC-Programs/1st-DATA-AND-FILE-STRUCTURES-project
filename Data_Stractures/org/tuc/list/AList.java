package org.tuc.list;

public class AList implements List{

  private Element[] myArray;
    private int size;
    private int maxSize;

    public AList(int maximum){
        this.maxSize=maxSize;
        this.myArray= new Element[maxSize];
        this.size=0;
        
    }
    /*
     * TO DO
     * Must put try...catch for exeptions
     * See again if the methods do the functionality of the project(last pages in the images of array)
     * 
     */

    @Override
    public boolean insert(Element element){
        if(size<maxSize){
            myArray[size]= element;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int key){

        if(size ==0){
            return false;
        }

        for(int i=0; i<size; i++){
            if(myArray[i].getKey()==key){
                for(int j=i; j<size-1; j++){
                    myArray[j]=myArray[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Element search(int key){
        for(int i=0; i<size; i++){
            if(myArray[i].getKey()==key){
                return myArray[i];
            }
        }

        return null;
    }



}
