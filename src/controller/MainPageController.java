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
    private final PortfolioBoardService portfolioBoardService = new PortfolioBoardService();
    private Session session;

    public MainPageController(Session session){
        this.session = session;
    }
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/")) {
            if(request.getMethod().equals("GET")) {
                if(session.isLogin()){
                    ArrayList<PortfolioBoard> myPortolioBoard = mainPageService.getMyPortlioBoard(session.getMember().getEmail());
                    modelAndView.getModel().put("myPortolioBoard", myPortolioBoard);
                }

                ArrayList<PortfolioBoard> boards = portfolioBoardService.getBoardList(0, 3);

                modelAndView.setLink("main");
                modelAndView.getModel().put("boards", boards);
            }
        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return modelAndView;
    }
}
