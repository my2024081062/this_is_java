package ch07.sec.from_eight_to_eleven;

public sealed class Person2 permits Employee, Manager {
    public String name;

    public void work(){
        System.out.println("하는 일이 결정되지 않았습니다." );
    }
}
