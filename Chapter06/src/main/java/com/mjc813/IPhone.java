package com.mjc813;

public class IPhone extends Phone {

    IPhone(int phoneId, String charger, String model, String OS, String color, String camera, String version, int width, int height){
        super(phoneId, charger, model, OS, color, camera, version, width, height);
    }

    @Override
    public void turnPower(){
        if(isPowerButton()){
            if(isPower()) setPower(false);
            else setPower(true);
        }
    }
    @Override
    public void charge(int volt){
        setBattery(getBattery() + volt > 100 ? 100 : getBattery() + volt);
    }
    @Override
    public void update(String version){
        setVersion(version);
    }
    @Override
    public void capture(){
        System.out.println(getCamera() + "로 사진을 찍었습니다.");
    }
    @Override
    public void pressPowerButton(){
        setPowerButton(true);
        this.turnPower();
        setPowerButton(false);
    }
    @Override
    public void pressVolumeUpButton(){
        if(isVolumeDownButton()) return;
        setVolumeUpButton(true);
        setVolume(getVolume()+5);
        setVolumeUpButton(false);
    }
    @Override
    public void pressVolumeDownButton(){
        if(isVolumeUpButton()) return;
        setVolumeDownButton(true);
        setVolume(getVolume()-5);
        setVolumeDownButton(false);
    }

    @Override
    public void isHandPhone(){
        if(getWidth() <400){
            System.out.println("작은 폰입니다.");
        }
        else{
            System.out.println("큰 폰입니다.");
        }
    }
}
