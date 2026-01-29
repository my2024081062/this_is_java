package ch08.sec.vehicle;

public class MyFunction {
	public void do2(Factory ic) {
		Move oResult1 = ic.makeMachine("m2-201");
		System.out.println("result = " + oResult1.toString());
		Object oResult2 = ic.makeMachine("z2-47814");
		System.out.println("result = " + oResult2.toString());
	}
}
