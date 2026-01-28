package ch07.sec.from_eight_to_eleven;

public class InstanceofExample {
    public static void info(Person1 p){
        System.out.println("name: " + p.getName());
        p.walk();

//        if(p instanceof Student){
//            Student s = (Student) p;
//            System.out.println("stuNum: " + s.getStuNum());
//            s.study();
//        }


        if(p instanceof Student1 s){
            System.out.println("stuNum: " + s.getStuNum());
            s.study();
        }
    }
}
