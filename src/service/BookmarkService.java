
package service;

import persistance.BookmarkRepository;

public class BookmarkService {

    private final BookmarkRepository bookmarkRepository = BookmarkRepository.getInstance();

    public BookmarkService() {

    }


    public boolean checkBookMark(String email, int portfolioId) {
        return bookmarkRepository.isBookmarked(email, portfolioId);
    }

    public void insertBookmark(String email, int id) {
        System.out.println("service");
        bookmarkRepository.insertBookmark(email, id);
    }

    public void deleteBookmark(String email, int id) {
        System.out.println("delete service");
        bookmarkRepository.deleteBookmark(email, id);
    }
}
