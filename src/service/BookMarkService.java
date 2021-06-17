
package service;

import persistance.BookmarkRepository;

public class BookMarkService {

    private final BookmarkRepository bookmarkRepository = BookmarkRepository.getInstance();

    public BookMarkService() {

    }


    public boolean checkBookMark(String email, int portfolioId) {
            return bookmarkRepository.isBookmarked(email, portfolioId);
    }

    public void insertBookmark(String email, int id) {
        bookmarkRepository.insertBookmark(email, id);
    }

    public void deleteBookmark(String email, int id) {
        bookmarkRepository.deleteBookmark(email, id);
    }
}
