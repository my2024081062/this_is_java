package ch07.sec.polym;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LifeOfHuman {
	private Human human;

	public void liveHuman() {
		if ( this.getHuman() == null ) {
			return;
		}
		System.out.printf("%s 이 살고 있습니다.\n", this.getHuman());
	}

	public void whoFamily(Human ... family) {
		if ( this.getHuman() == null ) {
			return;
		}
		System.out.printf("나는 %s 입니다. 내 가족은 %s 입니다.\n", this.getHuman(), Arrays.toString(family));
	}

	public Human getMyself() {
		return this.getHuman();
	}
}
