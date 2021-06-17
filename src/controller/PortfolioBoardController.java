package controller;

import domain.PortfolioBoard;
import service.PortfolioBoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PortfolioBoardController implements Controller {

    private final PortfolioBoardService portfolioBoardService = new PortfolioBoardService();

    private final Session session;

    public PortfolioBoardController(Session session){
        this.session = session;
    }


    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        //GET, POST
        if(url.equals("/portfolio-board")) {
            if(request.getMethod().equals("GET")) {
                ArrayList<PortfolioBoard> boards = portfolioBoardService.findBoards();
                modelAndView.setLink("portfolioBoard");
                modelAndView.getModel().put("boards", boards);
            }
            else if(request.getMethod().equals("POST")) {

            }
        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
