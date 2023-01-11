package spring.tv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//		TVFactory factory = new TVFactory();
//		TV tv = factory.getTV("엘지");
		// Spring에서 제공하는 factory 사용
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tv/tv.xml");
		TV tv = factory.getBean("tv2", TV.class); // 1. tv = new xxxxTV();
		tv.powerOn();
		tv.soundUp(5);
		tv.soundDown(3);
		tv.powerOff();
		TV tv2 = (TV)factory.getBean("tv2"); // 2. return tv (생성자 호출되지 않음)
		TV tv3 = (TV)factory.getBean("tv2"); // 3. return tv (생성자 호출되지 않음)
		
		// 빈 객체는 프로그램이 끝날 때까지 하나만 만들어서 공유함(Singleton)
		
		
		
	}

	
}

/* 
 * 개발자 - 일부 코드 수정시에 같이 따라서 변경 부분 많아진다 -> 최소화
 * 		  인터페이스 공통 기능 명세서 각각 tv들은 공통 메서드 구현 약속
 * 		  외부 공장으로부터 전달받은 TV 사용 - MAIN(객체생성제어권 -- 팩토리)
 * 		  
 * 		  1)inversion of control - 객체 생성 제어권을 내가 갖지 않고, 외부에서 받아와서 결정함(= 제어권을 다른 곳(Factory)으로 넘김)
 * 		  2)pojo 클래스 사용 가능
 * 		  3)프로그램 구현 형식 - 자바 디자인 패턴 - 내장 factory pattern + 인터페이스 - IOC 
 * 		  4)Singleton pattern - 1개 생성 공유
 * 
 * 		  xml -> spring -> main 
 * 
 * 		  5) MemberDAO MemberDTO 
 * 
 */

