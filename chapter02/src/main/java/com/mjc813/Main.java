package com.mjc813;
import ch02.sec02.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        System.out.println(" ");

        IntergerType it = new IntergerType();
        it.useInteger();
        System.out.println(" ");

        CharType ct = new CharType();
        ct.useChar();
        System.out.println(" ");

        FDType fdt = new FDType();
        fdt.useFloatDouble();
        System.out.println(" ");

        BooleanType bt = new BooleanType();
        bt.useBoolean();
        System.out.println(" ");

        StringType st = new StringType();
        st.useString();
        System.out.println(" ");

        TypeCasting tct = new TypeCasting();
        tct.lowToHigh();
        tct.highToLow();
        tct.useLongInteger();
        System.out.println(" ");
    }
}
