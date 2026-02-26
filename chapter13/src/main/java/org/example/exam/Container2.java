package org.example.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Container2<T,K> {
    T key;
    K value;

    public void set(T key, K value){
        this.setKey(key);
        this.setValue(value);
    }
}
