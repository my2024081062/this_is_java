package org.example.nintendo;

import lombok.Getter;

@Getter
public class Myclass<TYPE> implements CRUD<TYPE> {
    private Object[] myList = new Object[0];

    @Override
    public void add(TYPE item) {
        Object[] newList = new Object[this.getMyList().length+1];
        System.arraycopy(this.getMyList(),0,newList,0,this.getMyList().length);
        newList[this.getMyList().length] = item;
        this.myList = newList;
    }

    @Override
    public int size() {
        return myList.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TYPE set(int index, TYPE item) {
        if(index > myList.length){
            return item;
        }
        TYPE oldItem = (TYPE) myList[index];
        myList[index] = item;
        return oldItem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TYPE remove(int index) {
        if(myList.length == 0){
            return null;
        }
        Object[] newList = new Object[this.getMyList().length-1];
        System.arraycopy(this.getMyList(),0,newList,0,index);
        System.arraycopy(this.getMyList(),index+1,newList,index,this.getMyList().length -index -1);
        TYPE oldItem = (TYPE) myList[index];
        this.myList = newList;
        return oldItem;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TYPE get(int index) {
        if(index > myList.length){
            return null;
        }
        return (TYPE) myList[index];
    }

    @Override
    public String getJson(int index) {
        return myList[index].toString();
    }

    @Override
    public String getJsonAllItems() {
        StringBuilder Json = new StringBuilder("[");
        for(int i = 0; i < myList.length;i++){
            if(i == 0){
                Json.append(myList[i].toString());
            }
            else{
                Json.append(",").append(myList[i].toString());
            }
        }
        Json.append("]");
        return Json.toString();
    }
}
