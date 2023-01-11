package annotation.member;

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
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/member/member.xml");
		MemberDAO dao = factory.getBean("dao", MemberDAO.class); // dao안에서 dto 저장
		// xml에서 이미 줬기 때문에 아래 두 문장은 필요 없음
		//MemberDTO dto1 = factory.getBean("dto1", MemberDTO.class);
		//dao.setDto(dto1);
		boolean isLogin = dao.selectMember();
		if(isLogin) {
			System.out.println(dao.dto.getId() + " 회원님 정상 로그인되셨습니다.");
		}
		else {
			dao.insertMember();
		}
		
		// 생성된 Bean 이름들 출력
		System.out.println("=======================================================");
		String[] beanNames = factory.getBeanDefinitionNames();
		for (String name : beanNames) {
			System.out.println(name);
		}
		
	}
}
