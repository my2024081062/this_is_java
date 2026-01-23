package com.mjc813;

import java.time.LocalDate;

public class Student {
    private String name;
    private String hakbun;
    private LocalDate birthday;
    private String major;

    public Student(String name){
        this(name, LocalDate.now().getYear() + "", LocalDate.now(),"");
    }

    public Student(String name, String hakbun){
       this(name, hakbun, LocalDate.now(),"");
    }
    public Student(String name, String hakbun, LocalDate birthday){
        this(name, hakbun, birthday,"");
    }
    public Student(String name, String hakbun, LocalDate birthday, String major){
        this.name = name;
        this.hakbun = hakbun;
        this.birthday = birthday;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHakbun() {
        return hakbun;
    }

    public void setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void study(String room){
        System.out.printf("%s 이(가) %s에서 공부한다.",this.name, room);
    }
    public void study(int hour){
        System.out.printf("%s 이(가) %d시간 공부한다.",this.name, hour);
    }
    public void study(String room, int hour){
        System.out.printf("%s 이(가) %s에서 %d시간 공부한다.",this.name, room, hour);
    }
    public void study(String room, String hour){
        System.out.printf("%s 이(가) %s에서 %d시간 %s전공 공부한다.",this.name, room, Integer.parseInt(hour), this.major);
    }
}
