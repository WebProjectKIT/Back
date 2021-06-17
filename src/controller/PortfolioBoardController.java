package controller;

import domain.PortfolioBoard;
import service.PortfolioBoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class PortfolioBoardController implements Controller {

    private final PortfolioBoardService portfolioBoardService = new PortfolioBoardService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        //GET, POST
        if (url.equals("/portfolio-board")) {
            if (request.getMethod().equals("GET")) {
                ArrayList<PortfolioBoard> boards = portfolioBoardService.findBoards();
                modelAndView.setViewName("portfolioBoard");
                modelAndView.getModel().put("boards", boards);
            } else if (request.getMethod().equals("POST")) {

            }
        } else if (url.equals("/portfolio-board/detail")) {
            PortfolioBoard post = portfolioBoardService.findPostById(Long.parseLong(request.getParameter("id")));
            modelAndView.setViewName("boardDetail");
            modelAndView.getModel().put("post", post);
        } else if (url.equals("/portpolio-board/register")) {
            String title = request.getParameter("title");
            String contents = request.getParameter("contents");

            //TODO 포트폴리오 선택 어떻게 할지
//            PortfolioBoard board = new PortfolioBoard(title, contents);
//
//            portfolioBoardService.write(board);
//            modelAndView.setViewName("index");
        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
