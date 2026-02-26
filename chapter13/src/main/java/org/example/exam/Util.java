package org.example.exam;

public class Util {
    public static <K, V, P extends Pair<K,V>> V getValue(P pair,K key){
        if(pair.getKey().equals(key)){
            return pair.getValue();
        }
        else {
            return null;
        }
    }
}
