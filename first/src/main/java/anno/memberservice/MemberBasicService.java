package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("janservice")
public class MemberBasicService implements MemberService {

	@Autowired
	MemberDAO dao;
	
	// ioc를 위한 setter method
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
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
