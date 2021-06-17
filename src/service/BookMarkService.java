package service;

import persistance.BookmarkRepository;

import java.util.ArrayList;

public class BookMarkService {
        private final BookmarkRepository bookmarkRepository = BookmarkRepository.getInstance();

        public BookMarkService() {

        }


    public boolean checkBookMark(String email, int portfolioId) {
            return bookmarkRepository.isBookmarked(email, portfolioId);
    }
}
