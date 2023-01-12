package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	// controller의 역할 - model과 view를 만들어주는 역할
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// model 설정
		HelloDTO dto = new HelloDTO();
		dto.setMessage("컨트롤러가 view로 전달하는 모델입니다.");
		request.setAttribute("model", dto);
		
		// view 설정
		// jsp파일 이름 리턴
		return "hello.jsp"; // ${model.message}
		
	}

}
