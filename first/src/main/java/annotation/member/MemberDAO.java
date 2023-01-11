package annotation.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class MemberDAO {
	
	// 자동으로 연결 - setter injection(xml proprerty 태그 대체)
	@Autowired // 2개 이상 생성되어 있는 경우
	//@Qualifier("dto") // dto, dto2 중 Qualifier 지정된 것 선택
	MemberDTO dto;
	/* 찾는 과정
	 * 1. MemberDTO 타입 객체들 찾음 - 1개 자동 주입
	 * 2. 여러개 존재할 경우 - 변수명과 일치하는 객체 찾음 - 1개 자동 주입
	 * 3. 객체 여러 개 찾는다 - 이름 일치하지 않는다 - @Qualifier("dto2") 추가
	 * 
	 * */
	
	
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
