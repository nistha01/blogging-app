package nitish.bloggingapp.service;

import nitish.bloggingapp.repo.IFollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    IFollowRepo followRepo;
}
