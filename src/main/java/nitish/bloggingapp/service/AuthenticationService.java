package nitish.bloggingapp.service;

import nitish.bloggingapp.model.AuthenticationToken;
import nitish.bloggingapp.repo.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo authenticationRepo;

    public boolean authenticate(String email, String tokenValue) {
        //find thr actual token -> get the connected patient -> get its email-> verify with passed email

        AuthenticationToken token =  authenticationRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }

    public void deleteToken(String tokenValue) {
        AuthenticationToken token =  authenticationRepo.findFirstByTokenValue(tokenValue);
        authenticationRepo.delete(token);
    }

    public void saveToken(AuthenticationToken token) {
        authenticationRepo.save(token);
    }
}
