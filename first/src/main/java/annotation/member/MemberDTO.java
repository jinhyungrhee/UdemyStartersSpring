package annotation.member;

import org.springframework.stereotype.Component;
// MemberDTO dto = new MemberDTO();
// dto.setId("") -> 이를 지원해주는 어노테이션은 없음 (XML에서 작성)
@Component("dto")
public class MemberDTO {

	String id, pw, name, email, phone, address, indate;
	
	// 기본 생성자 반드시 필요!
	// Spring에서 Bean을 통한 생성은 모두 기본 생성자를 이용함!
	MemberDTO() {
		
	}
	
	MemberDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
}
