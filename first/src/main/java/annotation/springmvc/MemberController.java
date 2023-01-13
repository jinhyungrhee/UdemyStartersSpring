package annotation.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController { // controller가 입력받는 것을 통제함
	
	@Autowired
	@Qualifier("service2")
	MemberService service; // MemberBasicService 객체
	
	@GetMapping("/register")
	String insertMember() {
	
		return "member/register"; // WEB-INF/views/member/register.jsp (7개 데이터)
		
	}
	
	@PostMapping("/register")
	ModelAndView insertMember2(@ModelAttribute("dto") MemberDTO dto) { // 전달받으면서 모델로 사용하겠다고 명시
		/* 1. dto 입력 id와 pw spring/1111 인지 검사 - memberdao.selectmember()
		 * 2-1. 맞으면 이전 가입된 적이 있습니다. Spring 회원님은 정상 로그인되었습니다. -> '모델'로 생성
		 * 2-2. 아니면 dto 내부 모든 변수값 출력. 회원가입되셨습니다. -> '모델'로 생성
		 * 3. 
		 * */
		String result = service.registerMember(dto);
		
		ModelAndView mv = new ModelAndView(); // 모델 & 뷰 생성
		mv.addObject("result", result);
		//mv.addObject("dto", dto); // @ModelAttribute로 대체
		mv.setViewName("member/registersuccess");
		return mv;
	}
	
	/*
	@RequestMapping("/hello")
	public ModelAndView a() { // Model도 생성하고 View도 있음

		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); // reqeust.setAttribute 대신하는 표현
		mv.setViewName("hello"); // 확장자와 저장경로가 이미 정해져있음 -> 일관성
		return mv;
		
	}
	*/
	

}
