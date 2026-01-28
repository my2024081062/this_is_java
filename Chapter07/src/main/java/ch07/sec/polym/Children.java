package ch07.sec.polym;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Children extends Human {
	private String smallBody;

	public Children(String name, String smallBody) {
		super(name);
		this.setSmallBody(smallBody);
	}
}
