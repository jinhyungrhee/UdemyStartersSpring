package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service2") // default : memberBasicService
public class MemberBasicService implements MemberService {

	@Autowired
	MemberDAO dao;

	@Override
	public void registerMember() {
		
		boolean isLogin = dao.selectMember();
		if(!isLogin) {
			dao.insertMember();
		} 
		else {
			dao.login();
		}
	}

}
