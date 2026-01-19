package ch03.sec01;

public class Equation {
    public double equationFirst(int a, int b){
        return (double) -b / a ;
    }
    public void task(){
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println("z = " + z);
        System.out.println("=============================");

        int score = 85;
        String result = !(score>90) ? "가" : "나";
        System.out.println(result);
        System.out.println("=============================");

        int pencils = 534;
        int student = 30;

        int pencilsPerStudent = pencils / student;
        int pencilsLeft = pencils % student;
        System.out.println("pencilsPerStudent = " + pencilsPerStudent);
        System.out.println("pencilsLeft = " + pencilsLeft);
        System.out.println("=============================");

        int value = 356;
        System.out.println("value = " + value/100);
        System.out.println("=============================");

        int widthTop = 5;
        int widthBottom = 10;
        int height = 7;
        double area = (widthTop + widthBottom) / 2.0 * height;
        System.out.println("area = " + area);
        System.out.println("=============================");

        int a = 10;
        int b = 5;
        System.out.println(a > 7 && b <= 5);
        System.out.println(a % 3 == 2 || b % 2 != 1);
        System.out.println("=============================");

        double n = 5.0;
        double m = 0.0;
        if(m != 0.0){
            double o = n/m + 10.0;
            System.out.println("result = " + o);
        }else{
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("=============================");
    }
}
