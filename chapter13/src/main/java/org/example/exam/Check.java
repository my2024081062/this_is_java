package org.example.exam;

public class Check {
    public void check2(){
        Container1<String> container1 = new Container1<>();
        container1.setT("hgd");
        System.out.println("str: " + container1.getT());

        Container1<Integer> container2 = new Container1<>();
        container2.setT(6);
        System.out.println("value: " + container2.getT());
    }

    public void check3(){
        Container2<String,String> container1 = new Container2<>();
        container1.set("hgd","도적");
        System.out.println("name: " + container1.getKey());
        System.out.println("job: " + container1.getValue());

        Container2<String,Integer> container2 = new Container2<>();
        container2.set("hgd",35);
        System.out.println("name: " + container2.getKey());
        System.out.println("age: " + container2.getValue());
    }

    public void check4(){
       Pair<String,Integer> pair = new Pair<>("hgd",35);
       Integer age = Util.getValue(pair,"hgd");
       System.out.println("age: " + age);

        ChildPair<String,Integer> childPair = new ChildPair<>("hss",15);
        Integer childAge = Util.getValue(childPair,"hgd");
        System.out.println("age: " + childAge);

//        OtherPair<String,Integer> otherPair = new OtherPair<>("juc",15);
//        Integer otherPair = Util.getValue(otherPair,"hgd");
//        System.out.println("age: " + age);
    }
}
