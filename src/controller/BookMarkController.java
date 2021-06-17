package controller;

import service.BookmarkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookMarkController implements Controller {

    private final Session session;
    private final BookmarkService bookmarkService = new BookmarkService();

    public BookMarkController(Session session) {
        this.session = session;
    }

    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {

        ModelAndView modelAndView = new ModelAndView();


        if (url.equals("/bookmark/insert/")) {

            String email = session.getMember().getEmail();
            int id = Integer.parseInt(request.getParameter("id"));

            System.out.println(email);
            System.out.println(id);

            bookmarkService.insertBookmark(email, id);

            modelAndView.setLink("/front/");
            modelAndView.setDispatchType(View.REDIRECT);

        } else if (url.equals("/bookmark/delete/")) {


            String email = session.getMember().getEmail();
            int id = Integer.parseInt(request.getParameter("id"));


            System.out.println(email);
            System.out.println(id);

            bookmarkService.deleteBookmark(email, id);


            modelAndView.setLink("/front/");
            modelAndView.setDispatchType(View.REDIRECT);

        } else {       // display 404
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);

        }

        return modelAndView;
    }

}