package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {

	SqlSession session; // main으로부터 session값 받아와야함!
	
	// session setter 메서드 (외부로부터 객체 전달받기 위한 메서드)
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<MemberDTO> memberlist() {
		return session.selectList("member.memberlist");
	}
	
	// 가급적이면 mapping.xml 파일의 이름과 동일하게 설정!
	public int membercount() {	
		return session.selectOne("member.membercount");
	}
	
	public MemberDTO onemember(String id) {
		return session.selectOne("member.onemember", id);
	}
	
	public List<MemberDTO> paginglist(int[] limit) {
		return session.selectList("paginglist", limit);
	}
	
	public int insertmember(MemberDTO dto) {
		return session.insert("insertmember", dto);
	}
	
	public int updatemember(MemberDTO dto) {
		return session.update("updatemember", dto);
	}
	
	public int deletemember(String id) {
		return session.delete("deletemember", id);
	}
	
	public List<MemberDTO> searchmember(HashMap map) {
		return session.selectList("searchmember", map);
	}
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return session.selectList("addresssearch", addresslist);
	}
	
	public List<MemberDTO> combination(MemberDTO dto) {
		return session.selectList("combination", dto); // name, email 모두 존재
	}
	
	public List<HashMap<String, String>> memberboard(String writer) {
		return session.selectList("memberboard", writer);
	}
}
