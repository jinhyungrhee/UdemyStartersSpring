package tv;

public class TvMain {

	public static void main(String[] args) {
		
//		// 처음에는 삼성TV 사용
//		TV tv = new SamsungTV();
//		tv.powerOn();
//		tv.soundUp(5);
//		tv.soundDown(3);
//		tv.powerOff();
//		
//		// 중간에 LgTV로 변경
//		tv = new LgTV();
//		tv.powerOn();
//		tv.soundUp(5);
//		tv.soundDown(3);
//		tv.powerOff();
		
		// 메인 메서드가 어떤 객체를 만들어 사용할지 직접 결정하면 안됨
		// TVFactory에게 시켜서 대신 객체를 만들도록 해야함
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV("엘지");
		tv.powerOn();
		tv.soundUp(5);
		tv.soundDown(0);
		tv.powerOff();
	}

}

/* 
 * 개발자 - 일부 코드 수정시에 같이 따라서 변경 부분 많아진다 -> 최소화
 * 		  인터페이스 공통 기능 명세서 각각 tv들은 공통 메서드 구현 약속
 * 		  외부 공장으로부터 전달받은 TV 사용 - MAIN(객체생성제어권 -- 팩토리)
 * 		  
 * 		  inversion of control - 객체 생성 제어권을 내가 갖지 않고, 외부에서 받아와서 결정함(= 제어권을 다른 곳(Factory)으로 넘김)
 * 
 */

