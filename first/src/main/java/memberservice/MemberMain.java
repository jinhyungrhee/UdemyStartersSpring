package memberservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberMain {

	public static void main(String[] args) {
		// 이러한 문장들을 모두 Spring에서 받아와서 사용함 - IOC
		//MemberDAO dao = new MemberDAO(); 
		//MemberDTO dto1 = new MemberDTO();
		//MemberDTO dto2 = new MemberDTO();
		//MemberDTO dto3 = new MemberDTO();
		//dao.setDto(dto3);
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("memberservice/member.xml");
		//MemberService service = factory.getBean("service", MemberJanService.class); // dao안에서 dto 저장
		MemberService service = factory.getBean("service", MemberBasicService.class); // dao안에서 dto 저장
		service.registerMember();
		
		// 생성된 Bean 이름들 출력
		System.out.println("=======================================================");
		String[] beanNames = factory.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
	}
}
