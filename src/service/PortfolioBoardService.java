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
}
