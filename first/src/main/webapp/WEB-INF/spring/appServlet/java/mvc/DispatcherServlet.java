package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* http://localhost:801/nonspringmvc/...  */
// fron controller 패턴을 써야 하니까 한 곳으로 모아와야 함!
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); //   /nonspringmvc/nonspringmvc/hello
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length -1]; // hello
		System.out.println(result); // url 가장 마지막 요소 분리 출력
		
		// front controller의 역할 : url - controller 맵핑 
		// hello -> new HelloController() --> HelloDTO -> HELLO.JSP
		// list -> ListController --> ArrayList<HelloDTO> -> HELLO.JSP
		HandlerMapping mappings = new HandlerMapping();
		Controller controller = mappings.getController(result);
		String viewname = controller.handleRequest(request, response);
		
		// 포워드
		RequestDispatcher rd = request.getRequestDispatcher(viewname);
		rd.forward(request, response);
		
	}

}
