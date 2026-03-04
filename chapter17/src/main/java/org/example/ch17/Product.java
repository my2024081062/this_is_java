package org.example.ch17;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;
}
