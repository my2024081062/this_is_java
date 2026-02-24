package org.example.exam;

public class Exam2 {
    public void apply(){
        Product<Tv, String> product1 = new Product<>();
        product1.setKind(new Tv());
        product1.setModel("Smart Tv");
        Tv tv = product1.getKind();
        String tvModel = product1.getModel();
        System.out.println("Kind: " + tv + ", Model: " + tvModel);
        System.out.println("-------------------------------");

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("SUV");
        Car car = product2.getKind();
        String carModel = product1.getModel();
        System.out.println("Kind: " + car + ", Model: " + carModel);
        System.out.println("-------------------------------");

        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Car rentCar = carAgency.rent();
        rentCar.run();
        System.out.println("-------------------------------");

        Box<String> box1 = new Box<>();
        box1.setContent("100");

        Box<String> box2 = new Box<>();
        box2.setContent("100");

        boolean result = box1.compare(box2);
        System.out.println("result: " + result);
    }
}
