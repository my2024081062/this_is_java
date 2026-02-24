package org.example.exam;

import lombok.Getter;
@Getter
public class Packaging<T> {
    private final Object[] list;
    @SuppressWarnings("unchecked")
    public Packaging(){
        this.list = (T[]) new Object[10];
    }

    private int index = -1;
    public void add(T obj){
        if( this.index >= this.list.length){
            return;
        }
        this.list[++index] = obj;
    }
    @SuppressWarnings("unchecked")
    public T remove(){
        if( this.index < 0){
            return null;
        }
        return (T) this.list[index--];
    }
}
