package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="frontController", urlPatterns = "/*")
public class FrontController extends HttpServlet{
	
	private Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontController() {
		controllerMap.put("login", new LoginController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);

		if(uri.equals("/")) {
			System.out.println("정상");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/main.html");
			dispatcher.forward(request, response);

		} else {
			System.out.println("비정상");
			String [] tokens = uri.split("/");
			String domain = tokens[1];

			Controller controller = controllerMap.get(domain);

			if(controller == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}

			ModelAndView mv = controller.process(request, response, uri);//논리 이름, -> 물리이름
			String viewPath = viewResolver(mv.getViewName());

			View view = new View(viewPath);
			view.render(mv.getModel(), request, response);

		}
	}

	private String viewResolver(String viewName) {
		return "/WEB-INF/view/"+viewName+".jsp";
	}

}
