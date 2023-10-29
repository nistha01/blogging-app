package nitish.bloggingapp.service;

import nitish.bloggingapp.model.Likee;
import nitish.bloggingapp.model.Post;
import nitish.bloggingapp.model.User;
import nitish.bloggingapp.repo.ILikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    ILikeRepo likeRepo;

    public boolean isAlreadyLiked(Post postToBeLiked,User likingUser) {
        List<Likee> likes =  likeRepo.findByBlogPostAndLiker(postToBeLiked,likingUser);
        return (likes!=null && likes.size()!=0);


    }

    public void saveLike(Likee newLike) {
        likeRepo.save(newLike);
    }


    public String removeLikesByLikerAndPost(Post blogPostToBeUnLiked,User potentialLiker) {
     List<Likee> allLikes=likeRepo.findByBlogPostAndLiker(blogPostToBeUnLiked,potentialLiker);
        if(!allLikes.isEmpty())
        {
            likeRepo.deleteAll(allLikes);
            return "Un-liked";
        }
        {
            return "Note liked yet, cannot dislike!!";
        }


    }

    public String getLikesForPost(Post blogPost) {
        List<Likee> likes  = likeRepo.findByBlogPost(blogPost);

        return String.valueOf(likes.size());

    }

    public void clearLikesByPost(Post post) {
        List<Likee> allLikes=likeRepo.findByBlogPost(post);
        likeRepo.deleteAll(allLikes);
    }
}
