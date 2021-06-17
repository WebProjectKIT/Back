package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// map -> 1. "members", members(ArrayList) 
//        2. "auth", int auth
public class View {

	private String path;

	public static final int FORWARD = 1;
	public static final int REDIRECT = 2;


	public View(String path) {
		this.path = path;
	}

	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response, int dispatchType)
			throws ServletException, IOException {


		if(dispatchType == FORWARD) {

			model.forEach((key, value) -> request.setAttribute(key, value));
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);//물리? 논리?

			dispatcher.forward(request, response);
			System.out.println(path);
			System.out.println("test : forward 완료");

		} else if (dispatchType == REDIRECT){

			response.sendRedirect(path);

		}


	}
}
