package annotation.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// HelloControllersms /hello URL만 처리 가능 -> annotation으로 개선!
@Controller
public class HelloController {

	// XML 단점
	// 1) 필요하지 않은 매개변수 선언
	// 2) 리턴타입 고정
	// 3) 1개 URL 처리
	// 이런 것들을 개선하기 위한 방법 : annotation
	
	@RequestMapping("/hello")
	public ModelAndView a() { // Model도 생성하고 View도 있음

		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); // reqeust.setAttribute 대신하는 표현
		mv.setViewName("hello"); // 확장자와 저장경로가 이미 정해져있음 -> 일관성
		return mv;
		
	}
	
	@RequestMapping("/hello2")
	public String b() { // 매핑메서드 리턴타입 String - model없고 View만 있음(=jsp 이름)
		
		return "hello"; // WEB-INF/views/?.jsp (Spring 환경이 정하고 있는 것)
		
	}
	
	@RequestMapping("/hello3")
	public void c() { // 매핑메서드 리턴타입 String - model없고 View만 있음=>< sp 이름 자동 url 동일 = hello3.jsp
		
	}
	
	// controller의 역할 - model과 view를 만들어주는 역할
	/*
	 * @Override public String handleRequest(HttpServletRequest request,
	 * HttpServletResponse response) { // model 설정 HelloDTO dto = new HelloDTO();
	 * dto.setMessage("컨트롤러가 view로 전달하는 모델입니다."); request.setAttribute("model",
	 * dto);
	 * 
	 * // view 설정 // jsp파일 이름 리턴 return "hello.jsp"; // ${model.message}
	 * 
	 * }
	 */

}
