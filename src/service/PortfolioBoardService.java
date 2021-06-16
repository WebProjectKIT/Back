package service;

import domain.Member;
import domain.PortfolioBoard;
import persistance.PortfolioBoardRepository;

import java.util.ArrayList;

public class PortfolioBoardService {

    private final PortfolioBoardRepository portfolioBoardRepository = PortfolioBoardRepository.getInstacne();
    public PortfolioBoardService() {

    }

    public ArrayList<PortfolioBoard> findBoards() {
        return portfolioBoardRepository.findAll();
    }
}
