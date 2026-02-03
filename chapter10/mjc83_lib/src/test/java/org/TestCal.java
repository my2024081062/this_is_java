package org;

import org.example.machine.Calculator;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//메소드 체이닝이 안되는게 옴
import static org.assertj.core.api.Assertions.assertThat;

public class TestCal {
    @Test
    public void TestAdd1(){
        Calculator cal = new Calculator();
        assertThat(cal.add(-31,-22,-16)).isEqualTo(-69L);
    }
    @Test
    public void TestAdd2(){
        Calculator cal = new Calculator();
        assertThat(cal.add(1,2,3,5,9)).isEqualTo(20L);
    }
    @Test
    public void TestAdd3(){
        Calculator cal = new Calculator();
        assertThat(cal.add(9999,8888,7777,6666,5555)).isEqualTo(38885);
    }
}