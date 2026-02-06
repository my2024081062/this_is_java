package org.example.ch15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hash {
    public String name;
    public int age;

    @Override
    public int hashCode(){
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Hash Hash1){
            return Hash1.name.equals(this.getName()) && Hash1.getAge() == this.getAge();
        }
        return false;
    }
    
    public void hash1(){
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");
        set.add("JAVA");

        System.out.println("객체 수 : " + set.size());
    }

    public void hash2(){
        Set<Hash> set = new HashSet<Hash>();
        set.add(new Hash("h",30));
        set.add(new Hash("h",30));

        System.out.println("객체 수 : " + set.size());
    }
    public void hash3(){
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("JSP")){
                iterator.remove();
            }
        }
        System.out.println();

        set.remove("JDBC");

        for(String element : set){
            System.out.println(element);
        }
    }
}
