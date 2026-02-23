package org.example.check;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Check6 {
    private String id;
    private String name;

    @Override
    public String toString() {
        return this.id + ": " + this.name;
    }
}
