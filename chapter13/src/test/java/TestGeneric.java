import org.example.task.Generic;
import org.testng.annotations.Test;

public class TestGeneric {
    Generic<String,Integer> generic = new Generic<>();
    @Test
    public void testAdd(){
        generic.clear();
        generic.add("key1",10);
        generic.add("key2",20);
        generic.add("key3",30);
        generic.add("key3",40);
        System.out.println("size : " + generic.size());
    }
    @Test
    public void testGet(){
        generic.clear();
        generic.add("key1",10);
        generic.add("key2",20);
        generic.add("key3",30);
        int num = generic.get("key3");
        System.out.println("key3 : " + num);
    }
    @Test
    public void testRemove(){
        generic.clear();
        generic.add("key1",10);
        generic.add("key2",20);
        generic.add("key3",30);
        generic.remove("key2");
        System.out.println("size : " + generic.size());
    }
    @Test
    public void testChange(){
        generic.clear();
        generic.add("key1",10);
        generic.add("key2",20);
        generic.add("key3",30);
        generic.change("key1","key3");
        int num = generic.get("key3");
        System.out.println("key3 : " + num);
    }
}
