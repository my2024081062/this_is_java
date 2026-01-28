package ch07.sec.inheritance;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Child extends Parent {
	private int height;
	private int weight;

	public Child(int age, String name, int height, int weight) {
		super(age, name);
//		this.height = height;
		this.setHeight(height);
//		this.weight = weight;
		this.setWeight(weight);
	}

	public void setHeight(int height) {
		if ( height <= 0 || height >= 300 ) {
			return;
		}
		this.height = height;
	}

	public void setWeight(int weight) {
		if ( weight <= 0 || weight >= 500 ) {
			return;
		}
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("Child{%s, Height=%d, Weight=%d}", super.toString(), this.getHeight(), this.getWeight());
	}
}
