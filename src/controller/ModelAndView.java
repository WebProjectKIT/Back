package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

//model과 viewpath에 대한 정보를 담음
public class ModelAndView {
	
	private String link;

	//String -> 모델의 이름 
	private Map<String, Object> model = new HashMap<>();
	private int status;

	private int dispatchType;


	public ModelAndView() {
		status = HttpServletResponse.SC_OK;
		dispatchType = View.FORWARD; // Default forward
	}


	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public int getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(int dispatchType) {
		this.dispatchType = dispatchType;
	}


}
