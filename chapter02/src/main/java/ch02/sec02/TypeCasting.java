package ch02.sec02;

public class TypeCasting {
    public void lowToHigh(){
        byte var1 = 100;
        int var2 = var1;
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println(" ");
        char var3 = '가';
        int var4 = var3;
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
        System.out.println(" ");
        int var5 = 200;
        long var6 = var5;
        System.out.println("var5: " + var5);
        System.out.println("var6: " + var6);
        System.out.println(" ");
        long var7 = 300;
        float var8 = var7;
        System.out.println("var7: " + var7);
        System.out.println("var8: " + var8);
        System.out.println(" ");
        float var9 = 400.4f;
        double var10 = var9;
        System.out.println("var9: " + var9);
        System.out.println("var10: " + var10);
        System.out.println(" ");
    }
    public void highToLow(){
        int var1 = 100;
        byte var2 = (byte) var1;
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println(" ");
        int var3 = 65;
        char var4 = (char) var3;
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
        System.out.println(" ");
        long var5 = 200;
        int var6 = (int) var5;
        System.out.println("var5: " + var5);
        System.out.println("var6: " + var6);
        System.out.println(" ");
        double var7 = 300.3;
        int var8 = (int) var7;
        System.out.println("var7: " + var7);
        System.out.println("var8: " + var8);
        System.out.println(" ");
    }
    public void useLongInteger(){
        Long var1 = 30L;
        int var2 = var1.intValue();
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println(" ");

        Integer var3 = 30;
        long var4 = var3.longValue();
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
        System.out.println(" ");

        Integer var5 = 200;
        int var6 = var5;
        System.out.println("var5: " + var5);
        System.out.println("var6: " + var6);
        System.out.println(" ");
    }
}
