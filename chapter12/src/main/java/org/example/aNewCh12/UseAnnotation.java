package org.example.aNewCh12;

import java.lang.reflect.Method;

public class UseAnnotation {
    public void useAnnotation() throws Exception{
        Method[] declaredMethods = Annotations.class.getDeclaredMethods();
        for(Method method : declaredMethods){
            PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
            printLine(printAnnotation);
            method.invoke(new Annotations());
            printLine(printAnnotation);
        }
        System.out.println("--------------------------");
    }

    public static void printLine(PrintAnnotation printAnnotation){
        if(printAnnotation != null){
            int number = printAnnotation.number();
            String value = printAnnotation.value();
            for(int i = 0; i < number; i++){
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
