package org.example.task;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Generic<K,V> {
    private Object[] key_list = new Object[0];
    private Object[] value_list = new Object[0];

    public void add(K key, V value){
        if(this.isContains(key)){
            this.value_list[this.findIndex(key)] = value;
        }
        else {
            Object[] new_key_list = new Object[this.key_list.length + 1];
            Object[] new_value_list = new Object[this.value_list.length + 1];
            System.arraycopy(this.key_list, 0, new_key_list, 0, key_list.length);
            System.arraycopy(this.value_list, 0, new_value_list, 0, value_list.length);
            new_key_list[this.key_list.length] = key;
            new_value_list[this.value_list.length] = value;
            this.key_list = new_key_list;
            this.value_list = new_value_list;
        }
    }
    public void change(K key1, K key2){
        if(this.isContains(key1) && this.isContains(key2)){
            V tmp1 = this.get(key1);
            V tmp2 = this.get(key2);
            this.value_list[this.findIndex(key1)] = tmp2;
            this.value_list[this.findIndex(key2)] = tmp1;
        }
    }
    @SuppressWarnings("unchecked")
    public V get(K key){
        for(int i = 0; i < this.key_list.length;i++){
            if(this.key_list[i].equals(key)){
                return (V) value_list[i];
            }
        }
        return null;
    }
    private int findIndex(K key){
        for(int i = 0; i < this.key_list.length;i++){
            if(this.key_list[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    @SuppressWarnings("unchecked")
    public V remove(K key){
        if(this.isContains(key)){
            int index = this.findIndex(key);
            V returnValue = (V) this.value_list[index];

            Object[] new_key_list = new Object[this.key_list.length - 1];
            Object[] new_value_list = new Object[this.value_list.length - 1];
            System.arraycopy(this.key_list, 0, new_key_list, 0, index);
            System.arraycopy(this.key_list, index+1, new_key_list, index, key_list.length-index-1);
            System.arraycopy(this.value_list, 0, new_value_list, 0, index);
            System.arraycopy(this.value_list, index+1, new_value_list, index, value_list.length-index-1);
            this.key_list = new_key_list;
            this.value_list = new_value_list;
            return returnValue;
        }
        return null;
    }
    public boolean isContains(K key){
        for(int i = 0; i < this.key_list.length;i++){
            if(this.key_list[i].equals(key)){
                return true;
            }
        }
        return false;
    }
    public int size(){
        return this.key_list.length;
    }
    public void clear(){
        this.key_list = new Object[0];
        this.value_list = new Object[0];
    }
}
