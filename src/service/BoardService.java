package service;

import domain.Board;
import persistence.BoardRepository;

import java.util.ArrayList;

public class BoardService {
	private final BoardRepository boardRepository = BoardRepository.getInstance();
	public BoardService() {
		
	}

	public Board findPostById(Long id){
		return boardRepository.findById(id);
	}
	public void write(Board board) {
		boardRepository.save(board);
		        
	}
	public void update(Board board) {
		boardRepository.update(board);
	}
	public void delete(Long id) {
		boardRepository.deleteById(id);
        
	}
	public ArrayList<Board> findBoards() {
        return boardRepository.findAll();
    }
}
