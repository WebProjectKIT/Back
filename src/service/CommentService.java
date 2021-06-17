package service;

import domain.Comments;
import persistance.CommentsRepository;

public class CommentService {
    private final CommentsRepository commentsRepository = CommentsRepository.getInstacne();

    public CommentService() {

    }

    public void write(Comments comments) {
        commentsRepository.save(comments);
    }
}
