package controller;

import domain.PortfolioBoard;
import service.BookMarkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BookMarkController implements Controller {

    private final Session session;
    private final BookMarkService bookMarkService = new BookMarkService();

    public BookMarkController(Session session) {
        this.session = session;
    }

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();



        if(url.equals("/bookmark/insert/")) {

            String email = session.getMember().getEmail();
            int id = Integer.parseInt(request.getParameter("id"));


            bookMarkService.insertBookmark(email, id);

        } else if (url.equals("/bookmark/delete/")){


            String email = session.getMember().getEmail();
            int id = Integer.parseInt(request.getParameter("id"));

            bookMarkService.deleteBookmark(email, id);


        } else {       // display 404
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

    }
}
