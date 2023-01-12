package aop1;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {

	long start = 0;
	// 공통적으로 수행해야 할 메서드
	/*
	public void a() {
		start = System.currentTimeMillis();
		System.out.println("===> a 메서드는 핵심관심 이전에 호출 : " 
		+ new Date(start));
	}
	
	public void b() {
		System.out.println("===> b 메서드는 핵심관심 이후에 호출 : "
		+ (System.currentTimeMillis() - start) + " 소요시간(1/1000초)");
	}
	*/
	
	// 이전 + 타겟클래스 정보 + 이후 모두 실행하는 메서드
	public void c(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("===> c 메서드는 핵심관심 이전에 호출 : ");
			
			// joinpoint 메서드
			System.out.println("타겟 클래스 객체 = " + joinpoint.getTarget());
			System.out.println("타겟 메서드     = " + joinpoint.toLongString());
			Object[] args = joinpoint.getArgs();
			for (Object o : args) {
				System.out.println("매개변수 = " + o);
			}
			
			Object returnVal = joinpoint.proceed(); // 핵심 : joinpoint	
			// void메서드는 null을 출력하므로 if문으로 처리
			if(returnVal  != null) {
				System.out.println("리턴값 =" + returnVal);				
			}
			
			System.out.println("===> c 메서드는 핵심관심 이후 호출 : ");
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
}

/* aop1 패키지 모든 클래스, 모든 메서드 실행 이전 a 메서드 실행 구성
 * -> 스프링에게 시키는 방법 : xml + 어노테이션(@)
 *  1) common 객체 생성
 *  <bean id="common" class="aop1.Common" />
 * 
 * 	2) 만들어진 객체를 참조하여 공통관심 적용
 *	<aop:config>
 * 		<aop:pointcut expression="( * aop1.*.*(..))" id="pc" /> // * - 리턴타입, * - 모든 클래스 , * - 모든 메서드,  .. - 모든 메서드 매개변수
 * 		<aop:aspect id="aopaspect" ref="common" /> // 공통관심 : aspect
 * 		<aop:before method="a" pointcut-ref="pc"  /> // before : 실행 이전 , after : 실행 이후, around : 실행 이전/이후 모두
 * 	</aop:config>
 * 
 *  */
