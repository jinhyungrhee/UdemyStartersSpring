package ajax;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import spring.mybatis.MemberDTO;
import spring.mybatis.MemberService;

// 모든 메서드에 @ResponseBody가 붙어있으면 @RestController 붙어도됨!
@Controller
public class LoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/loginajax")
	public String loginajax() {
		return "ajax/loginform";
	}
	
	@ResponseBody
	@PostMapping(value="/loginajax", produces={"application/json;charset=utf-8"})
	public String loginajax2(String id, String pw) {
		String result = null;
		if(id.equals("ajax") && pw.equals("1234")) {
			result = "login 성공";
		}
		else {
			result = "login 실패";
		}
		
		return "{\"process\" : \"" +  result + "\" }";
	}
	
	@ResponseBody
	@PostMapping(value="/myinformajax", produces={"application/json;charset=utf-8"})
	public MemberDTO myinformajax(String id, String pw) {
		MemberDTO dto = service.onemember(id);
		if (dto.getPw().equals(pw)) {
			return dto;
		}
		else {
			return new MemberDTO();
		}
	}
	
	@GetMapping(value="/memberlistajax", produces={"application/json;charset=utf-8"})
	public @ResponseBody List<MemberDTO> memberlistajax() { // @ResponseBody는 리턴타입 앞에 있어도됨
		List<MemberDTO> list = service.memberlist();
		return list;
	}
	
	
	@ResponseBody
	@GetMapping(value="/paginglistajax/{page}", 
	produces={"application/json;charset=utf-8"})
	public List<MemberDTO> paginglistajax(@PathVariable("page") int page) { // @ResponseBody는 리턴타입 앞에 있어도됨
		// page 변수 1 / 2 / 3
		// select ... limit 0, 3 / 3, 3 / 6, 3
		int limit = (page - 1) * 3;
		int[] limitarr = new int[] {limit, 3};
		List<MemberDTO> list = service.paginglist(limitarr);
		return list;
	}
	
	@ResponseBody
	@PostMapping(value="/uploadajax",
	produces={"application/json;charset=utf-8"})
	// form name=uploadfile 으로 매핑시킴
	public String uploadajax(MultipartFile uploadfile) throws IOException { // **upload파일을 넣어주는 위치?**
		
		String savePath = "c:/upload/";
		//파일명1 추출
		String filename1 = uploadfile.getOriginalFilename();
		//파일이름 . 확장자 분리
		String beforeext1 = filename1.substring(0, filename1.lastIndexOf('.'));
		String ext1 = filename1.substring(filename1.lastIndexOf('.'));
		//	UUID.randomUUID()
		String newfilename1 = beforeext1 +"(" + UUID.randomUUID().toString() +")" + ext1;
		//파일내용1 추출해서 c:/upload/filename1 저장 
		File serverfile1 = new File(savePath + newfilename1);
		uploadfile.transferTo(serverfile1);
		
		return "{\"result\" : \"잘 받았습니다\"}";
	
	}
	
	
}