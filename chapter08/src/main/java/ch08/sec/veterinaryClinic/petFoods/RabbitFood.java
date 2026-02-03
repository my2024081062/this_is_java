package ch08.sec.veterinaryClinic.petFoods;

public class RabbitFood {
    private final static RabbitFood food = new RabbitFood();

    private RabbitFood(){

    }
    public static RabbitFood getInstance(){
        return RabbitFood.food;
    }

}
