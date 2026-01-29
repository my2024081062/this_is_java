package ch08.sec.electronics;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television implements RemoteControl{
    private int volume;
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
        this.volume = Math.max(RemoteControl.MIN_VOLUME,Math.min(RemoteControl.MAX_VOLUME,volume));
        System.out.println("현재 TV볼륨: " + this.getVolume());
    }
    private int memoryVolume;
    @Override
    public void setMute(boolean mute) {
        if(mute){
            this.setMemoryVolume(this.getVolume());
            System.out.println("무음 처리합니다.");
            this.setVolume(MIN_VOLUME);
        }
        else{
            System.out.println("무음 해제합니다.");
            this.setVolume(memoryVolume);
        }
    }
}
