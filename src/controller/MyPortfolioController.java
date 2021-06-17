package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPortfolioController implements Controller {

    private final Session session;

    public MyPortfolioController(Session session){
        this.session = session;
    }


    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        return null;
    }
}
