package ch07.sec;


public class SportsCar extends Car{
    @Override
    public void speedUp() {
        setSpeed(getSpeed()+10);
    }
    /*
    @Override
    public void stop() {
        System.out.println("스포츠카를 멈춤");
        this.setSpeed(0);
    }
     */
}
