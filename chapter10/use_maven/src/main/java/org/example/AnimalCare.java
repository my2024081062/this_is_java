package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCare {
    private String name;
    private int id;
    private Date enterCareDate;
    private Date externCareDate;
    private int visitCount;
}
