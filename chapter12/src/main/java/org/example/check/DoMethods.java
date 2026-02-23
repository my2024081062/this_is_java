package org.example.check;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class DoMethods {
    public void doCheck05(){
        HashSet<Check5> hashSet = new HashSet<>();
        hashSet.add(new Check5("1"));
        hashSet.add(new Check5("1"));
        hashSet.add(new Check5("2"));

        System.out.println("저장된 클래스 수 : " + hashSet.size());
    }

    public void doCheck06(){
        Check6 check6 = new Check6("blue","파랑");
        System.out.println(check6);
    }

    public void doCheck08(){
        long startTime = System.nanoTime();

        int[] scores = new int[1000];
        for(int i = 0; i < scores.length; i++){
            scores[i] = i;
        }
        int sum = 0;
        for(int score : scores){
            sum+=score;
        }
        double avg = sum * 1.0 / scores.length;
        System.out.println(avg);

        long endTime = System.nanoTime();
        System.out.println("실행 시간: " + (endTime - startTime) / 100000000.0 + "초");
    }

    public void doCheck09(){
        byte[] bytes = {-20,-107,-120,-21,-123,-107};
        String str = new String(bytes);
        System.out.println("str: " + str);
    }

    public void doCheck10(){
        String str = "";
        for(int i = 0; i <=100;i++){
            str += i;
        }
        System.out.println(str);

        str = "";

        StringBuilder sbr = new StringBuilder();
        for(int i = 0; i <=100;i++){
            sbr.append(i);
        }
        System.out.println(sbr.toString());
    }

    public void doCheck11(){
        String str = "아이디,이름,패스워드";

        StringTokenizer stringTokenizer = new StringTokenizer(str,",");
        while (stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            System.out.println(token);
        }
    }

    public void doCheck12(){
        Integer obj1 = 100;
        Integer obj2 = 100;
        Integer obj3 = 300;
        Integer obj4 = 300;

        System.out.println("Integer형 변수를 비교할 때 obj1 == obj2를 하면 값이 아니라 주소를 비교하게된다.");
        System.out.println("그런데 자바에서는 객체의 효율적 사용을 위해서 -128~127사이 값은 같은 주소를 사용해서 저장한다.");
        System.out.println("그래서 obj1 == obj2 (100)은 true, obj3 == obj4 (300)은 false의 결과가 나오게 된다.");
        System.out.println("값을 비교할 때는 equals 메소드를 사용하면 올바르게 비교할 수 있다.");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj3.equals(obj4));
    }

    public void doCheck15(){
        LocalDateTime dayNow = LocalDateTime.now();
        LocalDateTime day1231 = LocalDateTime.of(dayNow.getYear(),12,31,0,0,0);

        System.out.println("올해 12월 31일 까지 남은 일수: " + dayNow.until(day1231, ChronoUnit.DAYS));
    }

    public void doCheck16(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
        System.out.println(sdf.format(now));
    }

    public void doCheck17(){
        String id = "5Angel1004";
        String regExp = "[a-zA-Z]+\\w{7,11}";

        boolean isMatch = Pattern.matches(regExp,id);
        if(isMatch){
            System.out.println("ID로 사용이 가능합니다.");
        }
        else{
            System.out.println("ID로 사용이 불가능합니다.");
        }
    }

    public int doChecks(){
        DoMethods doMethods = new DoMethods();
        Method[] methods = doMethods.getClass().getDeclaredMethods();

        for(Method method : methods){
            if(method.getReturnType().equals(Void.TYPE) && method.getParameterCount() == 0){
                try{
                    method.setAccessible(true);
                    method.invoke(doMethods);
                    System.out.println("-------------------------");
                }
                catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
        return 1;
    }
}
