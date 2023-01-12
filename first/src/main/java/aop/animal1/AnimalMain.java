package aop.animal1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("aop/animal1/animal.xml");
		
		Animal[] animals = new Animal[3];
		
		animals[0] = factory.getBean("dog", Animal.class); // Dog 객체
		animals[1] = factory.getBean("cat", Animal.class); // Cat 객체
		animals[2] = factory.getBean("rabbit", Animal.class); // Rabbit 객체
		
		for (Animal a : animals) {
			a.lunch();
		}
		
	}

}
