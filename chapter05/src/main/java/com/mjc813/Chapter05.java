package com.mjc813;

import java.util.Optional;
import java.util.Scanner;

public class Chapter05 {
	public String runFifth04(String s) {
		if ( s ==  null ) {
			// 매개변수에 null 이 오면 NullPointException 예외가 발생한다.  try ~ catch 방어코드
			// 예외를 방어코드로 처리했다.
			return "";
		}
		return s.substring(0, 1);
	}

	public void runTest() {
		String a = "홍길동";
		String b = new String("홍길동");
		System.out.println("a.hashCode() : " + a.hashCode());
		System.out.println("b.hashCode() : " + b.hashCode());
		boolean b1 = a == b;
		System.out.println("a == b : " + b1);

		for ( int i = 0; i < a.length(); i++ ) {
			char ch = a.charAt(i);
			System.out.println("ch = " + ch);
		}

		String str1 = "I am a Boy, 홍길동, 안녕 Z";
		String str2 = str1.replace("a", "A");
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		String str3 = str1.substring(2, 4);
		System.out.println("str1 = " + str1);
		System.out.println("str3 = " + str3);
		int ndx1 = str1.indexOf("Z1");
		System.out.println("ndx1 = " + ndx1);
		String[] arr1 = str1.split(",");
		for ( String aItem : arr1 ) {
			System.out.println("aItem = " + aItem);
		}
	}
	public void runArray() {
		// for 문을 *, **, ***, ****, *****
		String[] line = {"*", "**", "***", "****", "*****"};
		for ( String item : line ) {
			System.out.println(item);
		}

		char[][] lines = new char[5][];
//		lines[0] = new char[1];
//		lines[1] = new char[2];
//		lines[2] = new char[3];
//		lines[3] = new char[4];
//		lines[4] = new char[5];
		for ( int i = 0; i < lines.length; i++ ) {
			lines[i] = new char[i+1];
			for ( int j = 0; j < lines[i].length; j++ ) {
				lines[i][j] = '*';
			}
		}
		for ( int i = 0; i < lines.length; i++ ) {
			for ( int j = 0; j < lines[i].length; j++ ) {
				System.out.printf("%c", lines[i][j]);
			}
			System.out.println();
		}
	}

	private int[] findMinMax( int[] intArray ) {
		int[] arrResult = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		for ( int number : intArray ) {
			if ( number < arrResult[0] ) {
				// 최솟값 구하기
				arrResult[0] = number;
			}
			if ( arrResult[1] < number ) {
				// 최댓값 구하기
				arrResult[1] = number;
			}
		}
		return arrResult;
	}

	public void acmicpcNet_problem_10818() {
		int[] count = this.getIntArrayFromScanner("처리할 갯수를 입력", 1);
		if ( count == null || count.length <= 0 || count[0] == 0 ) {
			return;
		}

		int[] intArray = this.getIntArrayFromScanner("3 -1 5..., 이런식으로 공백으로 숫자를 띄워서 입력", count[0]);
		if ( intArray == null || intArray.length <= 0 ) {
			return;
		}
		int[] resArray = this.findMinMax(intArray);
		System.out.printf("acmicpcNet_problem_10818 = %d, %d\n", resArray[0], resArray[1]);
	}

	private int[] getIntArrayFromScanner(String title, int length) {
		System.out.printf("%s : ", title);
		Scanner scanner = new Scanner(System.in);

		int[] nResult = new int[length];
		String sInput = scanner.nextLine();
		try {
			String[] arrItem = sInput.split(" ");
			for ( int i = 0, j = 0; i < nResult.length && j < arrItem.length; i++, j++ ) {
				nResult[i] = Integer.parseInt(arrItem[j]);
			}
			int j = 0;  // 예외가 발생하면 다음 문장을 실행 안하고 catch 블록으로 이동한다.
			j = 10 + j;
			// try 블록은 예외가 발생할수도 있는 문장을 try 블록으로 감싸는 역할을 한다.
		} catch (Exception e1) {
			// try 블록에서 예외가 발생되면 catch (예외클래스 객체이름) 블록으로 자동 실행된다.
			System.err.println(e1.getMessage() + ": 숫자 값을 입력하세요 !");
			nResult = null;
		}
		// 키보드 입력으로 정수형 문자열 입력받아서 정수로 변환하고 리턴
		return nResult;
	}

	public void task01(){
		boolean[] boolArray = new boolean[10];
		for (int i = 0; i<boolArray.length; i++){
			boolArray[i] = i % 2 == 0 ? true : false;
			System.out.print( i != boolArray.length-1 ? boolArray[i] + ", " : boolArray[i]);
		}
		System.out.println();
	}
	public void task01_1234(){
		int [] intArray = new int[30];
		for(int i = 0; i< intArray.length; i++){
			intArray[i] = i;
		}

		char [] charArray = new char[20];

		boolean[][] boolArray = new boolean[3][4];
		for(int i = 0; i < boolArray.length; i++){
			for(int j = 0; j < boolArray[i].length; j++){
				boolArray[i][j] = true;
			}
		}

		String[] stringArray = new String[50];
		for(int i = 0; i< stringArray.length; i++){
			stringArray[i] = "empty";
		}
	}
	public void task02(){
		int[][][] intDemention2 = {
				{
						{0, 0, 1, 1, 0, 0}
						, {1, 0, 0, 1, 0, 0}
						, {0, 1, 0, 1, 0, 0}
						, {0, 0, 1, 1, 0, 1}
						, {1, 0, 0, 0, 1, 0}
				}
				,{
						{1, 0, 1, 0, 0, 1}
						, {1, 0, 1, 1, 0, 1}
						, {0, 1, 0, 1, 0, 0}
						, {1, 0, 0, 1, 0, 1}
						, {1, 0, 1, 0, 0, 1}
				}
		};

		int countZeroOne[][] = {{0,0},{0,0}};
		for(int k = 0; k < intDemention2.length; k++){
			for(int i = 0; i < intDemention2[k].length; i++){
				for(int j = 0; j < intDemention2[k][i].length; j++){
					if(intDemention2[k][i][j] == 0) countZeroOne[k][0]++;
					else countZeroOne[k][1]++;
				}
			}
			System.out.println("0의 갯수는 " + countZeroOne[k][0] + "개, 1의 갯수는 " + countZeroOne[k][1] + "개.");
		}

	}
	public void task03(){
		char[][][] chInput = {
					{
						{'*', '*', '*', '*', ' '},
						{'*', '*', ' ', ' ', ' '},
						{'*', ' ', '*', '*', '*'},
					},
					{
						{'*', ' ', '*', '*', ' '},
						{'*', '*', ' ', ' ', ' '},
						{'*', ' ', '*', ' ', '*'},
						{' ', '*', '*', ' ', '*'},
						{'*', ' ', '*', ' ', '*'},
						{' ', ' ', '*', '*', '*'},
					},
					{
						{'*', '*', ' ', '*'},
						{'*', '*', ' ', ' '},
						{'*', ' ', '*', ' '},
						{' ', '*', '*', ' '},
						{'*', ' ', '*', '*'},
					},
				};
		char[][][] chOutput = new char[chInput.length][][];
		for(int k = 0; k < chOutput.length;k++){
			chOutput[k] = new char [chInput[k][0].length][];
			for(int i = 0; i < chOutput[k].length; i++){
				chOutput[k][i] = new char[chInput[k].length];
				for(int j = 0; j < chOutput[k][i].length; j++){
					chOutput[k][i][j] = chInput[k][j][i];
					System.out.print(chOutput[k][i][j]);
				}
				System.out.println();
			}
			System.out.println("=============");
		}
		
	}
}
