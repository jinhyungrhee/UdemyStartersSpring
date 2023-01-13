package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@RequestMapping("/list")
	public ModelAndView b() throws Exception {
		
		ListDTO dto = new ListDTO(new ArrayList<String>());
		dto.setList("홍길동");
		dto.setList("김영희");
		dto.setList("안철수");
		dto.setList("김갑수");
		dto.setList("손흥민");
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", dto); // reqeust.setAttribute 대신하는 표현
		mv.setViewName("list"); // 확장자와 저장경로가 이미 정해져있음 -> 일관성
		return mv;
		
	}

}
