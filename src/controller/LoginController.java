package controller;

import domain.Member;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoginController implements Controller {

    private final LoginService loginService = new LoginService();

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();
        Session session = new Session(request);

        if(url.equals("/login/")) {

            // 로그인 되어 있는지 검사
            if(!session.isLogin()) {
                // 정상 : 로그인 되어 있지 않은 경우

                Member member = loginService.login(request.getParameter("email"), request.getParameter("password"));

                if (member != null) { // 로그인 성공
                    request.getSession().setAttribute("member", member) ;

                    System.out.println("test : 로그인 성공");
                    modelAndView.setViewName("main");

                } else {   // 로그인 실패

                    System.out.println("test : 로그인 실패");
                    modelAndView.setViewName("login");

                }
            } else {    // 예외 : 이미 로그인 되어 있을 경우

                System.out.println("test : 이미 로그인 돼있음");
                modelAndView.setViewName("main");

            }

        } else {       // display 404
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

        return modelAndView;
    }




}
