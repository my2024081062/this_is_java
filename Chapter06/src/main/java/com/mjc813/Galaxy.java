package com.mjc813;

public class Galaxy extends Phone {

    private final boolean isPold;

    Galaxy(int phoneId, String charger, String model, String OS, String color, String camera, String version, int width, int height, boolean isPold){
        super(phoneId, charger, model, OS, color, camera, version, width, height);
        this.isPold = isPold;
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

    public boolean isPold() {
        return isPold;
    }

    public void isHandPhone(){
        if(getWidth() >= 400 && isPold()){
            System.out.println("폴드 폰입니다.");
        }
        else if(getWidth() <400){
            System.out.println("작은 폰입니다.");
        }
        else{
            System.out.println("큰 폰입니다.");
        }
    }

    public void poldPhone(){
        if(isPold()) System.out.println("이 폰은 접을 수 있습니다.");
        else System.out.println("이 폰은 접을 수 없습니다.");
    }
}
