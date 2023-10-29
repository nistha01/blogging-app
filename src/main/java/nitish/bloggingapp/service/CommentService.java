package nitish.bloggingapp.service;

import nitish.bloggingapp.model.Comment;
import nitish.bloggingapp.model.Post;
import nitish.bloggingapp.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    ICommentRepo commentRepo;

    public void addComment(Comment newComment) {
        commentRepo.save(newComment);
    }

    public Comment findCommnetById(Long commentId) {
        return  commentRepo.findById(commentId).orElse(null);
    }

    public void removeCommentById(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}
