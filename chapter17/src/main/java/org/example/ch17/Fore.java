package org.example.ch17;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Fore {
    private static int sum;

    public void run(){
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product(i,"상풍"+i,"멋진 회사", (int) (10000*Math.random()));
            list.add(product);
        }
        Stream<Product> stream = list.stream();
        stream.forEach(System.out::println);
        System.out.println();

        String[] strArr =  {"hgd","syg","kjv"};
        Stream<String> strStream = Arrays.stream(strArr);
        strStream.forEach((name) -> System.out.println(name + ", "));

        int[] intArr =  {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(intArr);
        intStream1.forEach((num) -> System.out.println(num + ", "));
        System.out.println();

        IntStream intStream2 = IntStream.rangeClosed(1,100);
        intStream2.forEach(a-> sum += a);
        System.out.println("총합: " + sum);
        System.out.println();

        try {
            Path path = Paths.get(Objects.requireNonNull(Fore.class.getResource("data.txt")).toURI());
            Stream<String> stream2 = Files.lines(path,Charset.defaultCharset());
            stream2.forEach(System.out::println);
            stream2.close();
        } catch (URISyntaxException | IOException | NullPointerException e){
            System.err.println(e.getMessage());
        }
        System.out.println();
    }
}
