package org.example.exam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product<K,M>{
    private K kind;
    private M model;
}
