import com.google.gson.*;
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
        System.out.println(gson.toJson(care));
    }
}
