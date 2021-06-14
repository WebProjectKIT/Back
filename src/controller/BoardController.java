package controller;

import domain.Board;
import service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class BoardController implements Controller{

	private final BoardService boardService = new BoardService();
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {		
		ModelAndView modelAndView = new ModelAndView();
		if(url.equals("/board/board-list")) {
			ArrayList<Board> boards = boardService.findBoards();
			modelAndView.setViewName("board/board-list");
			modelAndView.getModel().put("boards", boards);
		}
		else if (url.equals("/board/detail")) {

			Board post = boardService.findPostById(Long.parseLong(request.getParameter("id")));
			modelAndView.setViewName("board/board-detail");
			modelAndView.getModel().put("post", post);

		}
		else if (url.equals("/board/write")){
			modelAndView.setViewName("board/board-write");


			if(request.getMethod().equals("GET")) {
				modelAndView.setViewName("board/board-write");
			}
			else if(request.getMethod().equals("POST")) {
				Board board = new Board();
				board.setWriter(request.getParameter("writer"));
				board.setTitle(request.getParameter("title"));
				board.setContents(request.getParameter("contents"));

				boardService.write(board);
				modelAndView.setViewName("index");
			}

		}
		else if(url.equals("/board/update")){
			System.out.println("update");

			if(request.getMethod().equals("GET")) {

				Board post = boardService.findPostById(Long.parseLong(request.getParameter("id")));
				modelAndView.setViewName("board/board-update");
				modelAndView.getModel().put("post", post);

			}
			else if(request.getMethod().equals("POST")) {
				Board board = new Board();
				board.setId(Long.parseLong(request.getParameter("id")));
				board.setWriter(request.getParameter("writer"));
				board.setTitle(request.getParameter("title"));
				board.setContents(request.getParameter("contents"));

				boardService.update(board);
				modelAndView.setViewName("index");
			}



		}
		else if(url.equals("/board/delete")){

			boardService.delete(Long.parseLong(request.getParameter("id")));
			modelAndView.setViewName("index");

		}
		else {
			modelAndView.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return modelAndView;
	}
}
