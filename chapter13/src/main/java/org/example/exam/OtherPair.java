package org.example.exam;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OtherPair <K,V>{
    private K key;
    private V value;
}
