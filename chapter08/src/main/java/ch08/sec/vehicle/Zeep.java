package ch08.sec.vehicle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Zeep extends Wheel4 {
	private String serialNumber;

	public Zeep(String sn) {
		this.setSerialNumber(sn);
	}
	@Override
	public void slowMove() {
		System.out.println("Zeep (Wheel4) slow moving : " + this.getSerialNumber());
	}
}
