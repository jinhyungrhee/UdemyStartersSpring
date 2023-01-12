package springmvc;

import java.util.ArrayList;

public class ListDTO {
	
	ArrayList<String> list;
	

	public ListDTO(ArrayList<String> list) {
		super();
		this.list = list;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(String name) {
		list.add(name);
	}

}
