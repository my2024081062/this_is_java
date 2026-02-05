package com.mjc813.report.report02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mjc813GameMachineV1 {
	private int battery = 0;
	private MarioGame game1;

    public Mjc813GameMachineV1(){
        this.game1 = null;
    }

	public void runGame1() throws  Game1IsNullException, BatteryLessThan5Exception {
		if ( battery < 5 ) {
			// 배터리 5% 미만 이라는 예외를 만들어서 던져보세요
			// 예외클래스 이름은 BatteryLessThan5Exception
            throw new BatteryLessThan5Exception("BatteryLessThan5Exception 예외 발생");
		}
		if ( game1 == null ) {
			// game1 소프트웨어가 없다 라는 예외를 만들어서 던져 보세요
			// 예외클래스 이름은 Game1IsNullException
            throw new Game1IsNullException("Game1IsNullException 예외 발생");
		}
		game1.runGame();
	}
}
