package service;

import domain.Portfolio;
import persistance.BookmarkRepository;

public class MypageService {

    private final BookmarkRepository bookmarkRepository = BookmarkRepository.getInstance();

    public Portfolio[] findBookmarkedPortfolios(String email) {

        int [] list = bookmarkRepository.getListToEmail(email);


        return null;
    }
}
