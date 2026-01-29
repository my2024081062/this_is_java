package ch08.sec.vehicle;

public abstract class Wheel4 implements Move {
	private int wheel = 4;

	public void drive() {
		System.out.println("Wheel4 driving");
	}
	@Override
	public void move() {
		System.out.println("Wheel4 moving");
	}
	@Override
	public void fastMove() {
		System.out.println("Wheel4 fast moving");
	}
}
