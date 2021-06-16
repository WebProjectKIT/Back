package controller;

import domain.PortfolioBoard;
import service.MainPageService;
import service.PortfolioBoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MainPageController implements Controller {

    private final MainPageService mainPageService = new MainPageService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/")) {
            if(request.getMethod().equals("GET")) {
                ArrayList<PortfolioBoard> boards = mainPageService.findBoards();
//                ArrayList<PortfolioBoard>
                modelAndView.setViewName("main");
                modelAndView.getModel().put("boards", boards);
            }
        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
