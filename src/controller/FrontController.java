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

@WebServlet(name = "frontController", urlPatterns = "/front/*")
public class FrontController extends HttpServlet{
	
	private Map<String, Controller> controllerMap = new HashMap<>();
	
	public FrontController() {
		controllerMap.put("main", new MainPageController());
		controllerMap.put("login", new LoginController());
		controllerMap.put("my-page", new MypageController());
		controllerMap.put("my-portfolio", new MyPortfolioController());
		controllerMap.put("portfolio-board", new PortfolioBoardController());

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		conPath += "/front";
		String com = uri.substring(conPath.length());

		if (com.equals("/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/main.jsp");
			dispatcher.forward(request, response);
		} else {
			String[] tokens = com.split("/");
			String domain = tokens[1];
			Controller controller = controllerMap.get(domain);
			if (controller == null) {
				response.setStatus(HttpServletResponse.SC_ACCEPTED);
			}
			ModelAndView mv = controller.process(request, response, com);
			if (mv.getStatus() != HttpServletResponse.SC_OK) {
				// 예외처리
			}
			String viewPath = viewResolver(mv.getViewName());
			View view = new View(viewPath);    // viewPath 물리 이름 변환 필요
			view.render(mv.getModel(), request, response);
		}
	}

	private String viewResolver(String viewName) {
		return "/view/"+viewName+".jsp";
	}

}
