package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowRepo extends JpaRepository<Follow,Long> {
}
