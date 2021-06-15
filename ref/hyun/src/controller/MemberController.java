package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import service.MemberService;

public class MemberController implements Controller{
	
	private final MemberService memberService=new MemberService(); 
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		//GET, POST
		if(url.equals("/member/join")) {
			if(request.getMethod().equals("GET")) {
				modelAndView.setViewName("member/join-form");
			}
			else if(request.getMethod().equals("POST")) {
				Member member = new Member();
				member.setName(request.getParameter("name"));
				member.setAge(Integer.parseInt(request.getParameter("age")));
				memberService.join(member);
				modelAndView.setViewName("index");
			}
		}else if(url.equals("/member/members")) {
			ArrayList<Member> members = memberService.findMembers();
			modelAndView.setViewName("member/member-list");
			modelAndView.getModel().put("members", members);				
		}
		else {
			modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return modelAndView;
	}
}
