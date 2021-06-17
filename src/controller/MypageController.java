package controller;

import domain.Member;
import domain.Portfolio;
import domain.PortfolioBoard;
import service.MypageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MypageController implements Controller  {

    final private MypageService mypageService = new MypageService();

    private final Session session;

    public MypageController(Session session){
        this.session = session;
    }


    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();

        if(url.equals("/my-page/")) {

            // 로그인 체크
            if(session.isLogin()){ // 정상 : 로그인이 되어 있는 경우

                modelAndView.setLink("myPage");

                Member member = session.getMember();
                modelAndView.getModel().put("member", member);

                ArrayList<PortfolioBoard> bookmarkedPortfolios = mypageService.findBookmarkedPortfolios(member.getEmail());
                System.out.println(bookmarkedPortfolios.size());

                modelAndView.getModel().put("boards", bookmarkedPortfolios);

            } else { // 예외 : 로그인이 되어있지 않은 경우
                modelAndView.setLink("login"); // 로그인 페이지로 보내버리기

            }


        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }


        return modelAndView;
    }

}

