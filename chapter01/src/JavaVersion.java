public class JavaVersion {
    public static void main(String[] args){
        String myJavaVersion = System.getProperty("java.version").split("[.]")[0];
        System.out.println("My Java version = " + myJavaVersion + ".");
        //버전 21로 컴파일 후에 버전 17로 바꾸고 실행하면 버전 오류가 남
        //그래서 명령 프롬프트에서 버전 17로 컴파일을 다시하고 실행해야됨 (상위 버전으로 컴파일 후 하위버전으로 실행하고자 할때 오류)
    }
}
