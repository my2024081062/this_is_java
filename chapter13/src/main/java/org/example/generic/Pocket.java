package org.example.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Pocket<MT extends Number> {
    private String name;
    private Currency currency;
    private MT money;
}
