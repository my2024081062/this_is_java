package org.example;

import java.util.*;

public class Collective {
    public void createArrayList(){
        List<Board> boardList = new ArrayList<>();
        boardList.add(new Board("제목1","내용1","글쓴이1"));
        boardList.add(new Board("제목2","내용2","글쓴이2"));
        boardList.add(new Board("제목3","내용3","글쓴이3"));
        boardList.add(new Board("제목4","내용4","글쓴이4"));
        boardList.add(new Board("제목5","내용5","글쓴이5"));

        int size = boardList.size();
        System.out.println("총 객체 수: " + size);
        System.out.println();

        Board board = boardList.get(2);
        System.out.println(board.getSubject() + "\t" + board.getContent() +"\t" + board.getWriter());
        System.out.println();

        for(int i = 0; i < boardList.size(); i++){
            Board foard = boardList.get(i);
            System.out.println(foard.getSubject() + "\t" + foard.getContent() +"\t" + foard.getWriter());
        }
        System.out.println();

        boardList.remove(2);
        boardList.remove(2);

        for(Board b : boardList){
            System.out.println(b.getSubject() + "\t" + b.getContent() +"\t" + b.getWriter());
        }
        System.out.println("-----------------------");
    }
    public void createLinkedList(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long start;
        long end;

        start = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            list1.add(0,String.valueOf(i));
        }
        end = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 실행 시간: ", (end - start));


        start = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            list2.add(0,String.valueOf(i));
        }
        end = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "LinkedList 실행 시간: ", (end - start));
        System.out.println("-----------------------");
    }

    public void createHashSet(){
        Set<String> stringSet = new HashSet<>();

        stringSet.add("Java");
        stringSet.add("JDBC");
        stringSet.add("JSP");
        stringSet.add("Java");
        stringSet.add("Spring");

        int size = stringSet.size();
        System.out.println("총 객체 수: " + size);
        System.out.println("-----------------------");

        Set<Member> memberSet = new HashSet<Member>();
        memberSet.add(new Member("hgd",30));
        memberSet.add(new Member("hgd",30));

        System.out.println("객체 수 : " + memberSet.size());
        System.out.println("-----------------------");

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
        System.out.println("-----------------------");
    }

    public void createHashMap(){
        Map<String, Integer> map = new HashMap<>();

        map.put("신용권",85);
        map.put("홍길동",90);
        map.put("동장군",80);
        map.put("홍길동",95);

        System.out.println("총 Entry 수 : " + map.size());
        System.out.println();

        String key = "홍길동";
        int value = map.get(key);

        System.out.println(key + ": " + value);
        System.out.println();

        Set<String> keySet = map.keySet();
        for (String k : keySet) {
            Integer v = map.get(k);
            System.out.println(k + ": " + v);
        }
        System.out.println();

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ": " + v);
        }
        System.out.println();

        map.remove(" 홍길동");
        System.out.println("총 Entry 수 : " + map.size());
        System.out.println("-----------------------");
    }
}
