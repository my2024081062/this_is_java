package org.example.aNewCh12;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Boat {
    private String model;
    private String owner;

    public Boat(){}
    public Boat(String model){
        this.setModel(model);
    }
}
