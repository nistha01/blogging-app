package nitish.bloggingapp.repo;

import nitish.bloggingapp.model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
