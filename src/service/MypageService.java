package service;

import domain.Portfolio;
import domain.PortfolioBoard;
import persistance.BookmarkRepository;
import persistance.PortfolioBoardRepository;

import java.util.ArrayList;

public class MypageService {

    private final BookmarkRepository bookmarkRepository = BookmarkRepository.getInstance();

    private final PortfolioBoardRepository portfolioBoardRepository = PortfolioBoardRepository.getInstance();

    public ArrayList<PortfolioBoard>  findBookmarkedPortfolios(String email) {

        ArrayList<Integer> list = bookmarkRepository.getListByEmail(email);



        return portfolioBoardRepository.getBookmarkedPortfoliosByIDList(list);

    }
}
