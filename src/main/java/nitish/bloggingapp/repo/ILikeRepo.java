package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.Likee;
import nitish.bloggingapp.model.Post;
import nitish.bloggingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Likee,Long> {

    List<Likee> findByBlogPostAndLiker(Post postToBeLiked, User likingUser);


    List<Likee> findByBlogPost(Post blogPost);
}
