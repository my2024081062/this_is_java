public class Gugudan {
    public static void main(String[] args){
        for(int i = 2; i <= 9; i+=3){
            String lastString = ((i+2)==10) ? "" : " " + (i+2) + "단 출력";
            System.out.println(i + "단 출력        " + " " + (i+1) + "단 출력        " + lastString);
            for(int j = 1; j <= 9; j++){
                String lastInt = ((i+2)==10) ? "" : (i+2) + " * " + j + " = " + ((i+2) * j);
                String firstInt = i + " * " + j + " = " + (i * j);
                String space1 = firstInt.length() == 9 ? "       " : "      ";
                String middleInt = (i+1) + " * " + j + " = " + ((i+1) * j);
                String space2 = middleInt.length() == 9 ? "       " : "      ";
                System.out.println(firstInt + space1 + middleInt + space2 + lastInt);
            }
            System.out.println();
        }
    }
}
