package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontController", urlPatterns = "/front/*")
public class FrontController extends HttpServlet {

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
        Controller controller;

        if (com.equals("/")) {
            controller = controllerMap.get("main");

        } else {
            String[] tokens = com.split("/");
            String domain = tokens[1];
            controller = controllerMap.get(domain);

        }

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);

        } else {
            ModelAndView mv = controller.process(request, response, com);

            if (mv.getStatus() != HttpServletResponse.SC_OK) {
                // 예외처리
            }



            if(mv.getDispatchType()  == View.FORWARD) {
                String viewPath = viewResolver(mv.getLink());
                View view = new View(viewPath);    // viewPath 물리 이름 변환 필요
                view.render(mv.getModel(), request, response, mv.getDispatchType());

            } else {
                View view = new View(mv.getLink());
                view.render(mv.getModel(), request, response, mv.getDispatchType());

            }

        }


    }

    private String viewResolver(String viewName) {
        return "/view/" + viewName + ".jsp";
    }

}
