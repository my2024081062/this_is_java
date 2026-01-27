package ch07.sec;

public class Subject {
    public void listen(Student s, Professor p){
        if(!p.getMajor().equals("교양") && !s.getMajor().equals(p.getMajor())){
            System.out.println("전공 과목 교수가 아닙니다.");
            int grade = (int) (Math.random() * 4);
            double last1 = 0;
            System.out.println("수강을 듣습니다.");

            switch (grade){
                case 0 -> last1 = 3.0;
                case 1 -> last1 = 3.5;
                case 2 -> last1 = 4.0;
                case 3 -> last1 = 4.5;
            }
            s.setGrade(last1);
        }
    }
}
