package com.mjc813;

public abstract class Phone {
    private final int phoneId;
    private final int width;
    private final int height;
    private final String camera;
    private final String color;
    private final String OS;
    private final String model;
    private final String chargerType;
    private String version;
    private int battery;
    private boolean power;
    private boolean powerButton;
    private boolean volumeUpButton;
    private boolean volumeDownButton;
    private int volume;

    public Phone(int phoneId, String chargerType, String model, String OS, String color, String camera, String version, int width, int height) {
        this.power = false;
        this.volume = 0;
        this.volumeDownButton = false;
        this.volumeUpButton = false;
        this.powerButton = false;
        this.battery = 0;
        this.phoneId = phoneId;
        this.chargerType = chargerType;
        this.model = model;
        this.OS = OS;
        this.color = color;
        this.camera = camera;
        this.version = version;
        this.width = width;
        this.height = height;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public boolean isVolumeDownButton() {
        return volumeDownButton;
    }

    public boolean isVolumeUpButton() {
        return volumeUpButton;
    }

    public boolean isPowerButton() {
        return powerButton;
    }

    public int getBattery() {
        return battery;
    }

    public String getChargerType() {
        return chargerType;
    }

    public String getOS() {
        return OS;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getCamera() {
        return camera;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public void setVolumeUpButton(boolean volumeUpButton) {
        this.volumeUpButton = volumeUpButton;
    }

    public void setVolumeDownButton(boolean volumeDownButton) {
        this.volumeDownButton = volumeDownButton;
    }

    public void setPowerButton(boolean powerButton) {
        this.powerButton = powerButton;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isPower() {
        return power;
    }

    public int getVolume() {
        return volume;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    abstract void turnPower();

    abstract void charge(int volt);

    abstract void update(String version);

    abstract void capture();

    abstract void pressPowerButton();

    abstract void pressVolumeUpButton();

    abstract void pressVolumeDownButton();

    abstract void isHandPhone();

    public void printPhoneInfo(){
        System.out.println("고유번호 : " + getPhoneId() + ", 카메라 : " + getCamera() + ", 색깔: " + getColor()
        + ", 운영체제: " + getOS() + ", 기종: " + getModel() + ", 버전: " + getVersion()  + ", 충전 타입" + getChargerType());
    }

}
