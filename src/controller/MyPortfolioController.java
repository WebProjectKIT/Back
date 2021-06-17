package controller;

import domain.Member;
import domain.Portfolio;
import domain.PortfolioBoard;
import service.MyPortfolioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MyPortfolioController implements Controller {

    private final MyPortfolioService myPortfolioService = new MyPortfolioService();
    private final Session session;

    public MyPortfolioController(Session session){
        this.session = session;
    }

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();

        // 로그인 체크
        if(session.isLogin()){ // 정상 : 로그인이 되어 있는 경우


            if(url.equals("/my-portfolio/")){   // 목록 조회

                String userEmail = session.getMember().getEmail();

                int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

                Paging paging = myPortfolioService.getPagingInfo(page, userEmail);
                page = (page - 1) * 3;
                ArrayList<Portfolio> boards = myPortfolioService.getBoardList(page, paging.getPageSize(), userEmail);

                modelAndView.setLink("myPortfolio");
                modelAndView.getModel().put("paging", paging);
                modelAndView.getModel().put("boards", boards);



            } else if (url.equals("/my-portfolio/write/")){

                String title = request.getParameter("title");
                String link = request.getParameter("link");

                myPortfolioService.write(session.getMember().getEmail(), title, link);

                modelAndView.setLink("/front/my-portfolio/");
                modelAndView.setDispatchType(View.REDIRECT);


            } else if (url.equals("/my-portfolio/delete/")){
                myPortfolioService.delete(Integer.parseInt(request.getParameter("id")));
                modelAndView.setLink("/front/my-portfolio/");
                modelAndView.setDispatchType(View.REDIRECT);

            } else {
                modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

            }


        } else { // 예외 : 로그인이 되어있지 않은 경우
            modelAndView.setLink("login"); // 로그인 페이지로 보내버리기

        }

        return modelAndView;
    }


}
