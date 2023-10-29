package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findFirstByUserEmail(String newEmail);
}
