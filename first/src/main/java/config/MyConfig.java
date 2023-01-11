package config;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// <context:component-scan base-package="annotation.member" />
@Configuration // xml을 대신함
@ComponentScan(basePackages="config")
public class MyConfig {

	public static void main(String[] args) {
		
		// 해당 클래스 자신이 어노테이션 설정 파일임! (나 자신이 설정파일임) => ** 자바파일 자체를 Configuration으로 사용(Spring Boot)**
		ApplicationContext factory = new AnnotationConfigApplicationContext(MyConfig.class);
			
		// 생성된 Bean 이름들 출력
		System.out.println("=======================================================");
		String[] beanNames = factory.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
	}
	
	// 주입받기 위해서 사용하는 어노테이션
	// getList() 함수 호출 결과인 ArrayList를 주입받음 -> getList라는 변수명으로 사용
	@Bean
	ArrayList getList() {
		ArrayList list = new ArrayList();
		list.add(100);
		return list;
	}
	
	
}
