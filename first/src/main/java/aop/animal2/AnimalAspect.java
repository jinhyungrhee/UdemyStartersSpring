package aop.animal2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass=true) // 인터페이스 타입으로 줄때 필요한 어노테이션
public class AnimalAspect {

	@Pointcut("execution (public String aop.animal2.*.lunch())") // 필수
	void a() {} // pointcut의 이름 -> a
	
	@Around("a()")
	public void around(ProceedingJoinPoint p) {
		
		System.out.println("오늘은 뭐 먹을 거에요");
		try {
			// Object -> 다시 원래 
			String target = p.getTarget().toString(); // aop.animal1.Dog@16진수
			String[] names = target.split("@")[0].split("\\.");
			String classname = names[names.length-1];
			Object o = p.proceed();
			System.out.println(classname + " - " + o + "먹었군요." );
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	
	
	/*
	 * @Pointcut("execution (* aop.animal1.*.*(..))") public void pc() {} aop 실제 동작시
	 * 타겟 메서드가 포함됨 // 타겟 메서드가 실행될 때마다 채워짐
	 * 
	 * @Around("pc()") public void c(ProceedingJoinPoint joinpoint) { try { // 공통관심
	 * System.out.println("오늘은 뭐먹을거에요?");
	 * 
	 * // 핵심관심 Object returnVal = joinpoint.proceed(); System.out.println(returnVal
	 * + "먹었습니다.");
	 * 
	 * // 공통관심 System.out.println(joinpoint.getTarget().getClass().getSimpleName()+
	 * "-" + returnVal + " 먹었군요");
	 * 
	 * } catch(Throwable e) { e.printStackTrace(); } }
	 */

}
