package memberservice;

public class MemberDAO {
	
	MemberDTO dto;
	
	/* <property name="dto" ref="dto정의 bean id"> */
	public void setDto(MemberDTO dto) { 
		// dto1, dto2, dto3 + 하위클래스 객체(ioc, dependency injection)
		// ioc 구현을 위해 스프링은 dependency injection 방법을 사용함
		// 1> setter injection
		// 2> constructor injection
		this.dto = dto; // dto를 전달하는 메서드
	}
	
	public boolean selectMember() {
		// MemberDTO - id가 spring이고 pw가 1111이면 '정상 로그인'
		// dto 객체에 전달된 것중에 id
		if(dto.getId().equals("spring") && dto.getPw().equals("1111")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void insertMember() {
		
		System.out.println(dto.getId() + " 님 회원가입되셨습니다. ");
		
	}
	
	
	
	
	

}
