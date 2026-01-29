package ch08.sec.electronics;

public class SmartTelevision implements Searchable, RemoteControl{
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }

    @Override
    public void setVolume(int volume) {

    }

    @Override
    public void search(String url) {
        System.out.println(url + "을(를) 검색합니다.");
    }
}
