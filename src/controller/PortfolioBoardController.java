package controller;

import domain.Comments;
import domain.Portfolio;
import domain.PortfolioBoard;
import service.CommentService;
import service.MyPortfolioService;
import service.PortfolioBoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PortfolioBoardController implements Controller {

    private final PortfolioBoardService portfolioBoardService = new PortfolioBoardService();
    private final CommentService commentService = new CommentService();
    private final MyPortfolioService myPortfolioService = new MyPortfolioService();

    private final Session session;

    public PortfolioBoardController(Session session) {
        this.session = session;
    }


    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("member", session.getMember());
        //GET, POST
        if (url.equals("/portfolio-board/")) {
            if (request.getMethod().equals("GET")) {
                if(session.isLogin()){
                    ArrayList<Portfolio> myPortfolio = myPortfolioService.findByEmail(session.getMember().getEmail());
                    modelAndView.getModel().put("myPortfolio", myPortfolio);
                }
                int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

                Paging paging = portfolioBoardService.getPagingInfo(page);
                page = (page - 1) * 3;
                ArrayList<PortfolioBoard> boards = portfolioBoardService.getBoardList(page, paging.getPageSize());
                modelAndView.setLink("portfolioBoard");
                modelAndView.getModel().put("paging", paging);
                modelAndView.getModel().put("boards", boards);
            } else if (request.getMethod().equals("POST")) {

            }

        } else if (url.equals("/portfolio-board/detail/")) {
            PortfolioBoard post = portfolioBoardService.findPostById(Long.parseLong(request.getParameter("id")));
            ArrayList<Comments> comments = commentService.findCommentOfPost(Long.parseLong(request.getParameter("id")));
            modelAndView.setLink("boardDetail");
            modelAndView.getModel().put("post", post);
            modelAndView.getModel().put("comments", comments);

        } else if (url.equals("/portfolio-board/register/")) {
            String title = request.getParameter("title");
            String contents = request.getParameter("content");
            Long myPortfolio = Long.parseLong(request.getParameter("myPort"));

            PortfolioBoard board = new PortfolioBoard(session.getMember().getEmail(), myPortfolio, title, contents, 0);
            portfolioBoardService.write(board);
            modelAndView.setLink("/front/");
            modelAndView.setDispatchType(View.REDIRECT);

        } else if (url.equals("/portfolio-board/delete/")) {
            portfolioBoardService.delete(Long.parseLong(request.getParameter("id")));
            // TODO redirect 필요?
            modelAndView.setLink("main");

        } else if (url.equals("/portfolio-board/comment-register/")) {
            String email = session.getMember().getEmail();
            int postingId = Integer.parseInt(request.getParameter("id"));
            String content = request.getParameter("content");

            System.out.println(content);
            Comments comments = new Comments();
            comments.setEmail(email);
            comments.setContents(content);
            comments.setPostingId(postingId);

            commentService.write(comments);
            modelAndView.setLink("main");

        } else if (url.equals("/portfolio-board/comment-delete/")) {
            commentService.delete(Long.parseLong(request.getParameter("id")));
            // TODO redirect 필요?
            modelAndView.setLink("main");
        } else {
            modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return modelAndView;
    }
}
