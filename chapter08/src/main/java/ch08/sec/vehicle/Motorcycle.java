package ch08.sec.vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Motorcycle implements Move {
	private final int wheel = 2;
	private String serialNumber;

	public Motorcycle(String sn) {
		this.setSerialNumber(sn);
	}

	@Override
	public void move() {
		System.out.println("Motocycle 2 moving : " + this.getSerialNumber());
	}

	@Override
	public void fastMove() {
		System.out.println("Motocycle 2 fast moving : " + this.getSerialNumber());
	}

	@Override
	public void slowMove() {
		System.out.println("Motocycle 2 slow moving : " + this.getSerialNumber());
	}
}
