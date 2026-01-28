package ch07.sec.sugang;

import java.util.Arrays;

public class DB { //릴레이션 클래스를 만들어서 거기서 관리하고 여기는 릴레이션 배열로 관리하는게 좋을듯
    private static final DB singleDB = new DB();

    private DB() {}

    public static DB getInstance(){
        return singleDB;
    }

    public static void getInstance(Student s, Subject sb, double grade){
        singleDB.stock(s,sb,grade);
    }

    private static int DBid = 0;
    private int[] id = new int[0];
    private int[] hackbuns = new int[0];
    private String[] subName = new String[0];
    private Grade[] grades = new Grade[0];

    public void stock(Student s, Subject sb, double grade){
        int[] id1 = Arrays.copyOf(singleDB.id, singleDB.id.length+1);
        int[] hackbuns1 = Arrays.copyOf(singleDB.hackbuns, singleDB.hackbuns.length+1);
        String[] subName1 = Arrays.copyOf(singleDB.subName,singleDB.subName.length+1);
        Grade[] grades1 = Arrays.copyOf(singleDB.grades,singleDB.grades.length+1);

        id1[singleDB.id.length] = DBid++;
        hackbuns1[singleDB.hackbuns.length] = s.getHackbun();
        subName1[singleDB.subName.length] = sb.getName();

        if(grade >= 3.0 && grade <3.5){
            grades1[singleDB.grades.length] = Grade.C;
        }
        if(grade >= 3.5 && grade <4.0){
            grades1[singleDB.grades.length] = Grade.B;
        }
        if(grade >= 4.0 && grade <=4.5){
            grades1[singleDB.grades.length] = Grade.A;
        }

        singleDB.id = id1;
        singleDB.hackbuns = hackbuns1;
        singleDB.subName = subName1;
        singleDB.grades = grades1;
    }

    public void showAllGrade(){
        for(int i = 0; i < DBid; i++){
            System.out.println("학번: " + singleDB.hackbuns[i] + ", 과목명: " + singleDB.subName[i] + ", 성적: " + singleDB.grades[i]);
        }
    }
    public void showOneGrade(Student s){
        for(int i = 0; i < DBid; i++){
            if(singleDB.hackbuns[i] == s.getHackbun())
            System.out.println("과목명: " + singleDB.subName[i] + ", 성적: " + singleDB.grades[i]);
        }
    }
}
