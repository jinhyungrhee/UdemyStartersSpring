package springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// HelloControllersms /hello URL만 처리 가능
public class HelloController implements Controller {

	// 단점
	// 1) 필요하지 않은 매개변수 선언
	// 2) 리턴타입 고정
	// 3) 1개 URL 처리ㅣ
	// 이런 것들을 개선하기 위한 방법 : annotation
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); // reqeust.setAttribute 대신하는 표현
		mv.setViewName("hello"); // 확장자와 저장경로가 이미 정해져있음 -> 일관성
		return mv;
		
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
