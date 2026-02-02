package org.example;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Calendar;

public class TestJson {
    public void test(){
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
    }
}
