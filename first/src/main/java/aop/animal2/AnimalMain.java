package aop.animal2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop/animal2/animal.xml");
		
		// Animal 인터페이스 상속, 구현 클래스 - aspect pointcut시 인터페이스(o)/각각 구현클래스(o) 타입
		Animal[] animals = new Animal[3];
		
		animals[0] = (Dog)factory.getBean("dog"); // Dog 객체
		animals[1] = (Cat)factory.getBean("cat"); // Cat 객체
		animals[2] = (Rabbit)factory.getBean("rabbit"); // Rabbit 객체
		
		for (Animal a : animals) {
			a.lunch();
		}
		
	}

}
