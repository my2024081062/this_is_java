package org.example.exam;

import lombok.Getter;
@Getter
public class Packaging<T> {
    private final Object[] list;
    public Packaging(){
        this.list = new Object[10];
    }
    private int index = -1;
    public void add(T obj){
        if( this.index >= this.list.length-1){
            return;
        }
        this.list[++index] = obj;
    }
    @SuppressWarnings("unchecked")
    public T remove(){
        if( this.index < 0){
            return null;
        }
        //remove할 때 형변환
        T value = (T) list[index];
        list[index--] = null;
        return value;
    }
}
