package tv;

public class SamsungTV implements TV{

	public void powerOn() {
		System.out.println("SamsungTV:전원켜다");
	}
	public void powerOff() {
		System.out.println("SamsungTV:전원끄다");
	}
	public void soundUp(int v) {
		System.out.println("SamsungTV:" + v + "만큼 볼륨높이다");
	}
	public void soundDown(int v) {
		System.out.println("SamsungTV: " + v + "만큼 볼륨 낮추다");
	}
	
	
}
