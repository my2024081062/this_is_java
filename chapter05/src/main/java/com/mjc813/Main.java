package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
		// to see how IntelliJ IDEA suggests fixing it.
//		System.out.printf("Hello and welcome!");
//
//		for (int i = 1; i <= 5; i++) {
//			//TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//			// for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//			System.out.println("i = " + i);
//		}
		Chapter05 ch05 = new Chapter05();
//		String s1 = null;
//		System.out.println("ch05 = " + ch05.runFifth04(s1));
//
//		ch05.runTest();
//		ch05.acmicpcNet_problem_10818();
		ch05.task01();
		ch05.task02();
		ch05.task03();
		Task03 ta03 = new Task03();
		ta03.one();
		ta03.two();

		EnumName name1 = EnumName.NAME1; //프린트하면 문자열처럼 나옴
		System.out.println("name = " + name1);

		EnumName name2 = EnumName.NAME2;
		System.out.println("name = " + name2);

		EnumName name3 = EnumName.NAME3;
		System.out.println("name = " + name3);
		//EnumName 타입은 NAME1,2,3중 하나만 가지할 수 있다.
		//특정 열거타입인지 비교해서 사용하는데 많이 사용하는듯
	}

}
//public class가 있으면 public 선언이 안됨.
enum EnumName{
	NAME1, NAME2, NAME3;
}
