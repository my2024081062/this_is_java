package ch08.sec.vehicle;

public class MakeVehicle implements Factory {
	@Override
	public Move makeMachine(String s) {
		if ( s.charAt(0) == 'm' ) {
			Motorcycle m = new Motorcycle(s);
			System.out.println("MakeVehicle makeMachine (Motocycle) : " + m.toString());
			return m;
		} else if ( s.charAt(0) == 'z' ) {
			Zeep z = new Zeep(s);
			System.out.println("MakeVehicle makeMachine (Zeep) : " + z.toString());
			return z;
		} else {
			System.out.println("MakeVehicle makeMachine (Error) : serial error");
			return null;
		}
	}
}
