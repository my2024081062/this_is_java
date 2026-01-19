package ch03.sec01;

public class Chapter03_2 {
    public void third06(){
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);
        System.out.println("=============================");

        char ch1 = 'A';
        char ch2 = 'B';
        boolean result4 = (ch1 < ch2);
        System.out.println("result4: " + result4);
        System.out.println("=============================");

        int num3 = 3;
        double num4 = 3.0;
        boolean result5 = (num3 == num4);
        System.out.println("result5: " + result5);
        System.out.println("=============================");

        float num5 = 0.3f;
        double num6 = 0.3;
        boolean result6 = (num5 == num6);
        boolean result7 = (num5 == (float) num6);
        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);
        System.out.println("=============================");

        String str1 = "Hello";
        String str2 = "헬로";
        boolean result8 = (str1 == str2);
        boolean result9 = (str1.equals(str2));
        System.out.println("result8: " + result8);
        System.out.println("result9: " + result9);
        System.out.println("=============================");
    }
    public void third07(){
        int [] charCode = new int[4];
        charCode[0] = 'A';
        charCode[1] = 'a';
        charCode[2] = '5';
        charCode[3] = '!';

        for(int i = 0; i < 4; i++){
            if ((65 <= charCode[i]) & (charCode[i] <= 90)){
                System.out.println((char)charCode[i] + " is upper case");
            }
            if ((97 <= charCode[i]) && (charCode[i] <= 122)){
                System.out.println((char)charCode[i] + " is lower case");
            }
            if ((48 <= charCode[i]) && (charCode[i] <= 57)){
                System.out.println((char)charCode[i] +" is digit");
            }
            if ( (charCode[i] > 57) && (charCode[i] < 65) || (charCode[i] > 90) && (charCode[i] < 97) || (charCode[i] > 122 || charCode[i] < 48) ){
                System.out.println((char)charCode[i] + " is special");
            }
        }
        System.out.println("=============================");

        int value = 6;

        if( (value%2==0) | (value%3==0) ){
            System.out.println("value is multiple of 2 or 3");
        }

        boolean result = (value%2==0) | (value%3==0);
        if(!result){
            System.out.println("value is not multiple of 2 or 3");
        }
        System.out.println("=============================");
    }

    public void third08(){
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("=============================");

        int send = 136;
        System.out.println("send = " + send);
        byte receive = (byte) send;
        System.out.println("receive = " + receive);

        int unsignedReceive1 = receive & 255;
        System.out.println("unsignedReceive1 = " + unsignedReceive1);

        int unsignedReceive2 = Byte.toUnsignedInt(receive);
        System.out.println("unsignedReceive2 = " + unsignedReceive2);

        System.out.println("=============================");
    }

    public void third09(){
        int num1 = 1;
        int result1 = num1 << 3;
        int result2 = num1 * (int) Math.pow(2,3);
        System.out.println("num1 = " + num1);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("=============================");

        int num2 = 772;

        byte byte1 = (byte) (num2 >>> 24);
        int int1 = byte1 & 255;
        System.out.println("int1 = " + int1);

        byte byte2 = (byte) (num2 >>> 16);
        int int2 = Byte.toUnsignedInt(byte2);
        System.out.println("int2 = " + int2);

        byte byte3 = (byte) (num2 >>> 8);
        int int3 = byte3 & 255;
        System.out.println("int3 = " + int3);

        byte byte4 = (byte) num2;
        int int4 = Byte.toUnsignedInt(byte4);
        System.out.println("int4 = " + int4);
        System.out.println("=============================");
    }

    public void third10(){
        int result = 0;
        result +=10;
        System.out.println("result1 = " + result);
        result -=5;
        System.out.println("result2 = " + result);
        result *=3;
        System.out.println("result3 = " + result);
        result /=5;
        System.out.println("result4 = " + result);
        result %=3;
        System.out.println("result5 = " + result);
        System.out.println("=============================");
    }

    public void third11(){
        int score = 85;
        char grade = (score>90) ? 'A' : (score>80) ? 'B' : 'C';
        System.out.println(score + "점은 " + grade + "등급입니다.");
        System.out.println("=============================");
    }

    public void third12(){
        int var1 = 1;
        int var2 = 3;
        int var3 = 2;
        int result1 = var1 + var2 * var3;
        System.out.println("result = " + result1);
        int result2 = (var1 + var2) * var3;
        System.out.println("result = " + result2);
        System.out.println("=============================");
    }
}
