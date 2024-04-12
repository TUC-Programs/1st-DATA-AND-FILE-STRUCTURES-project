package org.tuc.list;

import org.tuc.List;
import org.tuc.MyElement;
import org.tuc.Element;


public class AList implements List{

    private MyElement[] myArray;
    private int size;
    private int maxSize;

    public AList(){
        
        this.myArray= new MyElement[maxSize];
        this.size=0;
        
    }

    /*
     * TO DO
     * 
     * See again if the methods do the functionality of the project(last pages in the images of array)
     * 
     */

    @Override
    public boolean insert(Element element){
        try{
            if(size<maxSize){
                if(size >0 ){
                    for(int i=0; i>0; i--){
                        myArray[i]=myArray[i-1];
                    }
                }
                myArray[0]= (MyElement) element;
                size++;
                return true;
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println("Array index out of bounds."+ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int key){

        try{
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
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println("Array index out of bounds."+ex.getMessage());
        }
        return false;
    }

    @Override
    public Element search(int key){
        try{
            for(int i=0; i<size; i++){
                if(myArray[i].getKey()==key){
                    return (Element) myArray[i];
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            System.err.println("Array index out of bounds"+ex.getMessage());
        }

        return null;
    }

}
