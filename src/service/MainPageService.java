package service;

import domain.PortfolioBoard;
import persistance.PortfolioBoardRepository;

import java.util.ArrayList;

public class MainPageService {

    private final PortfolioBoardRepository portfolioBoardRepository = PortfolioBoardRepository.getInstance();
    public MainPageService() {

    }
    public ArrayList<PortfolioBoard> findBoards() {
        return portfolioBoardRepository.findAll();
    }
}
