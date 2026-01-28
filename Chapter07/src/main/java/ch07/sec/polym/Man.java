package ch07.sec.polym;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Man extends Human {
	private String bigNeck;

	public Man(String name, String bigNeck) {
		super(name);
		this.setBigNeck(bigNeck);
	}
}
