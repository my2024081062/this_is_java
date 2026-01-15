public class Main {
    /**
     * api document 생성 하는 주석 실험1
     */
    public static String staticName = "정적 이름";
    public static void main(String[] args){

        for(String arg : args){
            System.out.println(arg); //Program arguments에 저장된 문자들이 배열로 저장
        }
        /**
         * api document 생성 하는 주석 실험2
         */
        String nonStaticName = "멤버 이름";

        System.out.println(staticName);
        System.out.println(nonStaticName);
    }
    public void useFunction(){
        staticWelcomes();
        nonStaticWelcomes();
    }

    /**
     * api document 생성 하는 주석 실험3
     */
    public static void staticWelcomes(){
        System.out.println("hello world!");
    }
    /**
     * api document 생성 하는 주석 실험4
     */
    public void nonStaticWelcomes(){
        System.out.println("hello world!");
    }
}
