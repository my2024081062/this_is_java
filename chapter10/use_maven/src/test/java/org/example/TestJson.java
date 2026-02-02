package org.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

public class TestJson {
    @Test
    public void test1(){
        Calendar cal = Calendar.getInstance();
        cal.set(2026,Calendar.FEBRUARY,5);
        AnimalCare care = new AnimalCare(
            "뽀삐", 101, Calendar.getInstance().getTime(), cal.getTime(), 2
        );

        Gson gson = new Gson();
        gson.toJson(1);            // ==> 1
        gson.toJson("abcd");       // ==> "abcd"
        Long val = 10L;
        gson.toJson(val); // ==> 10
        int[] values = { 1 };
        System.out.println(gson.toJson(values));
        String s = gson.toJson(care);
        System.out.println(s);

        AnimalCare result = gson.fromJson(s, AnimalCare.class);
        System.out.println(result.toString());

        assertThat(result.getName()).isEqualTo("뽀삐");
        assertThat(result.getId()).isEqualTo(101);
        assertThat(result.getVisitCount()).isEqualTo(2);

//        assertThat(result.getEnterCareDate()).isEqualTo(care.getEnterCareDate());
    }
    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        cal.set(2025,Calendar.OCTOBER,2);
        AnimalCare care = new AnimalCare(
            "뽀삐", 101, Calendar.getInstance().getTime(), cal.getTime(), 2
        );

        Gson gson = new Gson();
        gson.toJson(1);            // ==> 1
        gson.toJson("abcd");       // ==> "abcd"
        Long val = 10L;
        gson.toJson(val); // ==> 10
        int[] values = { 1 };
        System.out.println(gson.toJson(values));
        String s = gson.toJson(care);
        System.out.println(s);

        AnimalCare result = gson.fromJson(s, AnimalCare.class);
        System.out.println(result.toString());

        assertThat(result.getName()).isEqualTo("뽀삐");
        assertThat(result.getId()).isEqualTo(101);
        assertThat(result.getVisitCount()).isEqualTo(2);

        assertThat(result.getEnterCareDate()).isEqualTo(care.getEnterCareDate());
    }
}
