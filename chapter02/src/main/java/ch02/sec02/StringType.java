package ch02.sec02;

public class StringType {
    public void useString(){
        String name = "홍길동";
        String jobs = "프로그래머";
        System.out.println(name);
        System.out.println(jobs);

        String str = "나는 \"자바\"를 배웁니다.";
        System.out.println(str);

        str = "번호\t이름\t직업";
        System.out.println(str);

        System.out.println("나는\n");
        System.out.println("자바를\n");
        System.out.println("배웁니다.\n");
    }
}
