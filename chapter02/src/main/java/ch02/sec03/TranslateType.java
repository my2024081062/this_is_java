package ch02.sec03;

public class TranslateType {
    public void useTranslate(){
        //과제1
        //교재 2-9, 2-10 의 예제를 TranslateType 클래스의 useTranslate() 멤버 메소드에 구현하고 main 에서 실행하세요
        byte v1 =
                10 + 20;
        System.out.println("result1: " + v1);
        System.out.println(" ");

        byte v2 = 10;
        byte v3 = 20;
        int v4 =
                v2 +
                v3;
        System.out.println("result2:" + v4);
        System.out.println(" ");

        byte v5 = 10;
        int v6 = 20;
        long v7 = 30L;
        long v8 =
                v5 +
                v6 +
                v7;
        System.out.println("result3: " + v8);
        System.out.println(" ");

        char v9 = 'A';
        char v10 = 1;
        int v11 =
                v9 +
                v10;
        System.out.println("result4: " + v11);
        System.out.println(" ");

        int v12 = 10;
        int v13 =
                v12
                / 4;
        System.out.println("result5: " + v13);
        System.out.println(" ");

        int v14 = 10;
        double v15 =
                v14
                / 4.0;
        System.out.println("result6: " + v15);
        System.out.println(" ");

        int v16 = 10;
        int v17 = 20;
        double v18 =
        (double) v16
                / v17;
        System.out.println("result7: " + v18);
        System.out.println(" ");

        int b1 = Integer.parseInt("10");
        double b2 = Double.parseDouble("10.5");
        boolean b3 = Boolean.parseBoolean("true");
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        System.out.println(" ");

        String str1 = String.valueOf(10);
        String str2 = String.valueOf(10.5);
        String str3 = String.valueOf(true);
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str3: " + str3);
        System.out.println(" ");
    }
}


