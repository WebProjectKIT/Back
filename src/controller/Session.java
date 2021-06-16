package controller;

import domain.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {

    private HttpSession session;

    public Session(HttpServletRequest request){
        session = request.getSession();
    }

    boolean isLogin(){
        return session.getAttribute("member") != null;
    }

    Member getMember(){
        return (Member) session.getAttribute("member");
    }

}
