package aop.animal1;

import org.springframework.stereotype.Component;

// target
public class Cat implements Animal{

	
	@Override
	public String lunch() {
		String food = "생선";
		System.out.println(food + " 먹었습니다.");
		return food;
	}
	
}
