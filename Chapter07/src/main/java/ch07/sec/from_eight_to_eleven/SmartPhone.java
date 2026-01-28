package ch07.sec.from_eight_to_eleven;

public class SmartPhone extends Phone{
    public SmartPhone(String owner) {
        super(owner);
    }
    public void internetSearch(){
        System.out.println("인터넷 검색을 합니다." );
    }
}
