package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	//@RequestMapping(value="/login", method=RequestMethod.GET) // Spring 3.x
	@GetMapping("login") // Spring 4.x
	//public void loginform() {} //메서드 이름 자유로움 - 메서드명과 jsp 파일이 동일하면 void 리턴
	public String loginform() {
		return "loginform"; // view 이름(jsp 파일명) 리턴
	} 
	
	//@RequestMapping(value="/login", method=RequestMethod.POST)
	/*
	@PostMapping("login")
	public ModelAndView loginprocess(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// db 로그인 정상 확인
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginsuccess");
		
		return mv;
	}
	*/
	
	// Spring 특징인 IoC, DI 활용
	/*
	@PostMapping("login")
	public ModelAndView loginprocess(
			@RequestParam(value="id2", required=false, defaultValue="아이디") String id, String pw) { // 전달받는 parameter이름과 매개변수 이름이 동일한 경우, 주입됨!
		
		// Filter post = utf-8 로 인코딩을 바꿔주는 Spring Filter
		
		
		// Spring이 대신 처리
		// Servlet API를 가급적이면 사용하지 말자! (종속성 x)
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");
	
		// db 로그인 정상 확인
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginsuccess");
		
		return mv;
	}
	*/
	
	/*
	@PostMapping("login")
	public ModelAndView loginprocess(LoginDTO dto, int age) { // id--dto.setId(id) - DTO 내부 변수명과 파라미터 명이 동일해야 함!
		
		System.out.println(age);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginresult", dto);
		mv.setViewName("loginsuccess");
		
		return mv;
	}
	*/
	
	// 따로 ModelAndView 만들 필요 없이 ModelAttribute 어노테이션 사용
	// 입력값을 받아서 DTO로 넘겨주는 역할
	@PostMapping("login")
	public String loginprocess(@ModelAttribute("loginresult") LoginDTO dto) { 
		
		// -- mv.addObject("loginresult", dto.setId(request.getParameter("id"))
		return "loginsuccess"; // 해당 JSP만 "loginresult" 사용 가능
		
	}
	
	// Controller가 생성된 다음(맨 처음에) 만들어짐
	@ModelAttribute("all") // Controller가 View에 전달하는 데이터 (모든 JSP 공유 가능)
	public String all() {
		return "모든 뷰에서 사용 가능합니다."; // JSP 모든 View에서 공유해서 사용
	}
	
}
