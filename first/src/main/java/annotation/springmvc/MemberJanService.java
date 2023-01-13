package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberJanService implements MemberService {

	// DAO 두 개 필요
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
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



	@Override
	public String registerMember(MemberDTO dto) {
		boolean isLogin = memberDao.selectMember(dto);
		if(!isLogin) {
			memberDao.insertMember(dto);
			//pointDao.setPoint(10000);
			System.out.println(pointDao.getPoint() + " 포인트를 받았습니다.");
			return "";
		} else {
			return "";
		}
	}

}
