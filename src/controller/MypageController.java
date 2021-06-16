package controller;

import domain.Member;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MypageController implements Controller  {
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();
        Session session = new Session(request);

        if(url.equals("/my-page/")) {

            // 로그인 체크
            if(session.isLogin()){ // 정상 : 로그인이 되어 있는 경우

                Member member = session.getMember();
                modelAndView.getModel().put("member", member);
                modelAndView.setViewName("myPage");


            } else { // 예외 : 로그인이 되어있지 않은 경우
                modelAndView.setViewName("login"); // 로그인 페이지로 보내버리기

            }


        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }


        return modelAndView;
    }

}

