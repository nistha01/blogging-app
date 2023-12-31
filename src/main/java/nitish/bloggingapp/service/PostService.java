package nitish.bloggingapp.service;

import jakarta.transaction.Transactional;
import nitish.bloggingapp.model.Likee;
import nitish.bloggingapp.model.Post;
import nitish.bloggingapp.model.User;
import nitish.bloggingapp.repo.ILikeRepo;
import nitish.bloggingapp.repo.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;
    @Autowired
    LikeService likeService;
    @Autowired
    CommentService commentService;

    @Autowired
    AuthenticationService authenticationService;




    public void addBlogPost(Post blogPost) {
        //set creation time
        blogPost.setPostCreatedTimeStamp(LocalDateTime.now());
        //then save
        postRepo.save(blogPost);
    }

    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }


    public Post getPost(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }

    @Transactional
    public String deletePost(Long postId) {
        //find the post
        Post deltPost=postRepo.findById(postId).orElse(null);
        //delete all likes
        likeService.clearLikesByPost(deltPost);

        //delete all comments
        commentService.deleteAllComments(deltPost);
        //delete the post
        postRepo.deleteById(postId);
        return "post deleted successfully";

    }
}

