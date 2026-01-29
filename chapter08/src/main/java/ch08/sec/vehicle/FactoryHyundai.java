package ch08.sec.vehicle;

public class FactoryHyundai {
	public void makeObject() {
		Motorcycle m424 = new Motorcycle("m424-1111");
		m424.fastMove();
		m424.move();
		m424.slowMove();

		Zeep zep1 = new Zeep("zep1-1234");
		zep1.fastMove();
		zep1.move();
		zep1.slowMove();

		this.startMoveSlow(m424);
		this.startMoveSlow(zep1);
	}

	private void startMoveSlow(Move machine) {
		machine.slowMove();
	}
}
