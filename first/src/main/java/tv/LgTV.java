package tv;

public class LgTV implements TV {

	public void powerOn() {
		System.out.println("LgTV:전원켜다");
	}
	public void powerOff() {
		System.out.println("LgTV:전원끄다");
	}
	public void soundUp(int v) {
		System.out.println("LgTV:" + v + "만큼 볼륨높이다");
	} 
	public void soundDown(int v) {
		System.out.println("LgTV:" + v + "만큼 볼륨낮추다");
	} 
	
	
}
