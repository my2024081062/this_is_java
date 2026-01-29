package ch08.sec.electronics;

public class DoImpl {
    public void doElectronics(){
        RemoteControl au = new Audio();
        RemoteControl tv = new Television();

        au.turnOn();
        au.setVolume(5);

        au.setMute(true);
        au.setMute(false);

        tv.turnOn();
        au.turnOff();

        tv.setVolume(5);

        tv.setMute(true);
        tv.setMute(false);

        RemoteControl.changeBattery();
    }
    public void doService(){
        Service se = new ServiceImpl();
        se.defaultMethod1();
        se.defaultMethod2();

        Service.staticMethod1();
        Service.staticMethod2();
    }
}
