package service;

import domain.PortfolioBoard;
import persistance.PortfolioBoardRepository;

import java.util.ArrayList;

public class PortfolioBoardService {

    private final PortfolioBoardRepository portfolioBoardRepository = PortfolioBoardRepository.getInstance();
    public PortfolioBoardService() {

    }

    public ArrayList<PortfolioBoard> findBoards() {
        return portfolioBoardRepository.findAll();
    }

    public PortfolioBoard findPostById(long id) {
        return portfolioBoardRepository.findById(id);
    }

    public void write(PortfolioBoard board) {
        portfolioBoardRepository.save(board);
    }

    public void delete(long id) {
        portfolioBoardRepository.deleteById(id);
    }
}
