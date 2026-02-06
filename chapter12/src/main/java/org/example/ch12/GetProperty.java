package org.example.ch12;

import java.util.Properties;
import java.util.Set;

public class GetProperty {
    public void getProperty(){
        String osName = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        System.out.println(osName);
        System.out.println(userName);
        System.out.println(userHome);

        System.out.println("-------------");
        System.out.println("key : value");
        System.out.println("-------------");

        Properties properties = System.getProperties();
        Set<Object> keys = properties.keySet();

        for(Object key_val : keys){
            String key = (String) key_val;
            String val = System.getProperty(key);
            System.out.printf("%-40s: %s\n",key,val);
        }
    }
}
