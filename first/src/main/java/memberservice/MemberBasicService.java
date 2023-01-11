package memberservice;

public class MemberBasicService implements MemberService {

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
	}

}
