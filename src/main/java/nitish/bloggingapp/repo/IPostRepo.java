package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Long> {

}
