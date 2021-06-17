package service;

import domain.Comments;
import persistance.CommentsRepository;

import java.util.ArrayList;

public class CommentService {
    private final CommentsRepository commentsRepository = CommentsRepository.getInstacne();

    public CommentService() {

    }

    public void write(Comments comments) {
        commentsRepository.save(comments);
    }

    public ArrayList<Comments> findCommentOfPost(long id) {
        return commentsRepository.findAllCommentOfPost(id);
    }
}
