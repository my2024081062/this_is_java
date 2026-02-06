package org.example.ch12;

public class DoCh12Example {
    public void doSomething() throws Exception{
        Member member = new Member(null);
        member.member();

        Student student = new Student(123,"123");
        student.student();
        student.studentHashSet();

        SmartPhone smartPhone = new SmartPhone("삼성전자", "안드로이드");

        String s = smartPhone.toString();
        System.out.println(s);
        System.out.println(smartPhone);

        Record record = new Record("123","h",30);

        System.out.println(record.id());
        System.out.println(record.name());
        System.out.println(record.age());
        System.out.println(record.toString());
        System.out.println();


        Record r1 = new Record("11","abc",20);
        Record r2 = new Record("11","abc",20);

        System.out.println("r1.hashCode(): " + r1.hashCode());
        System.out.println("r2.hashCode(): " + r2.hashCode());
        System.out.println("r1.equals(r2): " + r1.equals(r2));

        ErrAndIn errEndIn = new ErrAndIn();
        errEndIn.doErr();
        errEndIn.doIn();

        GetProperty getProperty = new GetProperty();
        getProperty.getProperty();

        BytesToString bytesToString = new BytesToString();
        bytesToString.bytesToString();

        StringBuilderAndStringTokenizer stringBuilderAndStringTokenizer = new StringBuilderAndStringTokenizer();
        stringBuilderAndStringTokenizer.doStringBuilder();
        stringBuilderAndStringTokenizer.doStringTokenizer();
    }
}
