package annotation.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListControllerAnswer implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<String> list = new ArrayList();
		list.add("홍길동");
		list.add("김길동");
		list.add("이길동");
		list.add("최길동");
		list.add("나길동");

		ModelAndView mv = new ModelAndView();
		mv.addObject("memberlist", list); // reqeust.setAttribute 대신하는 표현
		mv.setViewName("listAnswer"); // 확장자와 저장경로가 이미 정해져있음 -> 일관성
		return mv;
		
	}

}
