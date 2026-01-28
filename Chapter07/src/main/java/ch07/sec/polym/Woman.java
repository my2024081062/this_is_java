package ch07.sec.polym;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Woman extends Human {
	private String softSkin;

	public Woman(String name, String softSkin) {
		super(name);    // this.setName(name); 이거는 안됨. 부모 생성자 호출 꼭 필요하다.
		this.setSoftSkin(softSkin);
	}
}
