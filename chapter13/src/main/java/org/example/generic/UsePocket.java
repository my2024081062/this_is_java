package org.example.generic;
import java.math.BigDecimal;

public class UsePocket {
    public void doSome(){
        Pocket <Double> my_pocket = new Pocket<>("나",Currency.EURO,0.0);
        Pocket <Integer> other_pocket = new Pocket<>("나",Currency.WON,1000);
//        Pocket <Tv> another_pocket = new Pocket<>("나",Currency.DOLLAR,new Tv());
        Pocket <BigDecimal> another_pocket = new Pocket<>("나",Currency.WON,BigDecimal.ONE);
    }
}
