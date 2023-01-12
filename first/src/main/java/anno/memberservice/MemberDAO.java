package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("memberdao")
public class MemberDAO {
	
	@Autowired // dto1, dto2, dto3
	@Qualifier("dto2") // 세 개중에 하나 명시 필요
	MemberDTO dto;
	
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
	
	public void login() {
		System.out.println(dto.getId() + "님 로그인되셨습니다. ");
	}
	
	
	
	

}
