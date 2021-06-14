package controller;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//model과 viewpath에 대한 정보를 담음
public class ModelAndView {
	
	private String viewName;
	//String -> 모델의 이름 
	private Map<String, Object> model = new HashMap<>();
	private int status;
	
	public ModelAndView() {
		status = HttpServletResponse.SC_OK;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
