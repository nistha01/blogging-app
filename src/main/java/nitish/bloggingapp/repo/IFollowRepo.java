package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.Follow;
import nitish.bloggingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFollowRepo extends JpaRepository<Follow,Long> {
    List<Follow> findByCurrentUserAndCurrentUserFollower(User target, User follower);
}
