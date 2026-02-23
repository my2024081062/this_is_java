package org.example.aNewCh12;

public class UseBoxing {
    public void boxingAndUnBoxing(){
        Integer obj = 100;
        System.out.println("obj: " + obj.intValue());

        int value = obj;
        System.out.println("value: " + value);

        int result = obj + 100;
        System.out.println("result: " + result);
        System.out.println("--------------------------");
    }

    public void valueCompare(){
        Integer obj1 = 300;
        Integer obj2 = 300;

        System.out.println("use == : " + (obj1 == obj2));
        System.out.println("use equals() : " + (obj1.equals(obj2)));
        System.out.println();

        Integer obj3 = 100;
        Integer obj4 = 100;

        System.out.println("use == : " + (obj3 == obj4));
        System.out.println("use equals() : " + (obj3.equals(obj4)));
        System.out.println();
        System.out.println("--------------------------");
    }
}
