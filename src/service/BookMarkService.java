package service;

public class BookMarkService {


    public void insertBookmark(String email, int id) {
        bookmarkRepository.insertBookmark(email, id);
    }

    public void deleteBookmark(String email, int id) {
        bookmarkRepository.deleteBookmark(email, id);
    }


}
