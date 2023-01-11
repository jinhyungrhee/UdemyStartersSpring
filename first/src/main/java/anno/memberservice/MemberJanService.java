package anno.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("jan")
public class MemberJanService implements MemberService {

	// DAO 두 개 필요
	MemberDAO memberDao;
	PointDAO pointDao;
	
	
	@Override
	public void registerMember() {

		boolean isLogin = memberDao.selectMember();
		if(!isLogin) {
			memberDao.insertMember();
			//pointDao.setPoint(10000);
			System.out.println(pointDao.getPoint() + " 포인트를 받았습니다.");
		}
		
	}
	
	
	// setter메서드만 생성
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}



	public void setPointDao(PointDAO pointDao) {
		this.pointDao = pointDao;
	}





}
