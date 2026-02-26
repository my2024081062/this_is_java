package org.example.nintendo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NintendoGame {
    private String name;
    private Grade grade;
    private Integer price;

    @Override
    public String toString() {
        return "{\"name\":\"" + this.getName() + "\", \"grade\":\"" + this.getGrade().toString() +"\", \"price\":\"" + this.getPrice() + "\"}";
    }
}
