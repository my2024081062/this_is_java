package org.example.aNewCh12;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class UseReflection {
    public void getClassSimpleInfo(){
        Class<Boat> clazz = Boat.class;
        System.out.println("패키지: " + clazz.getPackage().getName());
        System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
        System.out.println("클래스 전체 이름: " + clazz.getName());
        System.out.println("--------------------------");
    }

    public void getClassInfo(){
        Class<Boat> clazz = Boat.class;
        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.print(constructor.getName() + "(");
            Class[] parameters = constructor.getParameterTypes();
            UseReflection.printParameters(parameters);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType().getName() + " " + field.getName());
        }
        System.out.println();

        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName() + "(");
            Class[] parameters = method.getParameterTypes();
            UseReflection.printParameters(parameters);
            System.out.println(")");
        }
        System.out.println("--------------------------");
    }
    public void getResourceURL(){
        Class clazz = Boat.class;
        try {
            String photo1Path = clazz.getResource("/photo1.jpg").getPath(); //src/main/resources 폴더 안에 두어야함
            String photo2Path = clazz.getResource("/images/photo2.jpg").getPath();
            System.out.println(photo1Path);
            System.out.println(photo2Path);
        }
        catch (NullPointerException npe){
            System.out.println("getResourceURL 메소드에서 경로 참조 못함.");
        }
    }

    private static void printParameters(Class[] parameters){
        for(int i = 0; i < parameters.length; i++){
            System.out.print(parameters[i].getName());
            if(i<(parameters.length-1)){
                System.out.print(", ");
            }
        }
    }
}
