package ch07.sec;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Television {
    private double panel;
    private int madeYear;

    public Television(double panel, int madeYear) {
        this.panel = panel;
        this.madeYear = madeYear;
    }
}
