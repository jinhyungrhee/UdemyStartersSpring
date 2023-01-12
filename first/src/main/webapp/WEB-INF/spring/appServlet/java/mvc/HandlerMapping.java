package mvc;

import java.util.HashMap;

public class HandlerMapping {
	
	// 어떤 컨트롤러로 연결할지는 HandlerMapping에서 컨트롤러를 주입함
	HashMap<String, Controller> mappings;
	HandlerMapping() {
		mappings = new HashMap();
		mappings.put("hello", new HelloController());
	   //mappings.put("list", new ListController()); 
		
	}

	Controller getController(String url) {
		System.out.println("HandlerMapping 실행중");
		return mappings.get(url);
	}
}
