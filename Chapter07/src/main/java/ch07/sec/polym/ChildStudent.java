package ch07.sec.polym;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChildStudent extends Woman {
	private String ban;

	public ChildStudent(String name, String smallBody, String ban) {
		super(name, smallBody);
		this.setBan(ban);
	}
}
