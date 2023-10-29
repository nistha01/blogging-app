package nitish.bloggingapp.service;

import nitish.bloggingapp.model.*;
import nitish.bloggingapp.repo.IUserRepo;
import nitish.bloggingapp.service.encryption.HashingEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    PostService postService;
    @Autowired
    LikeService likeService;
    @Autowired
    CommentService commentService;

    @Autowired
    AuthenticationService authenticationService;

    public String userSignUp(User newUser) {
        //check if user is already registered
        String newEmail = newUser.getUserEmail();

        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if (existingUser != null) {
            return "email already in use";
        }
        //if not then signUp;
        // passwords are encrypted before we store it in the table

        String signUpPassword = newUser.getUserPassword();//password passed in new user

        try {
            String encryptedPassword = HashingEncryption.encrypt(signUpPassword);

            newUser.setUserPassword(encryptedPassword);


            // patient table - save patient
            userRepo.save(newUser);
            return "Blogging user registered";

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignIn(String email, String password) {
        //check if user is already registered or not by signingUp
        //if not then return saying signUp first
        User existingUser = userRepo.findFirstByUserEmail(email);

        if (existingUser == null) {
            return "Not a valid email, Please sign up first !!!";
        }

        //password should be matched

        try {
            String encryptedPassword = HashingEncryption.encrypt(password);

            if (existingUser.getUserPassword().equals(encryptedPassword)) {
                // return a token for this sign in
                AuthenticationToken token = new AuthenticationToken(existingUser);
                authenticationService.saveToken(token);

                return token.getTokenValue();

            } else {
                //password was wrong!!!
                return "Invalid Credentials!!!";
            }

        } catch (NoSuchAlgorithmException e) {

            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    //authenticate tokenValue
    public String userSignOut(String email, String tokenValue) {
        //verify the token related to the same mailId of user
        if (authenticationService.authenticate(email, tokenValue)) {
            authenticationService.deleteToken(tokenValue);//if token value matches then delete
            return "Sign Out successful!!";
        }
        //if not then can't delete
        else {
            return "Un Authenticated access!!!";
        }
    }


    public String addBlogPost(String tokenValue, Post blogPost, String email) {
        //if token value is correct then save
        //authenticate for valid user
        if (authenticationService.authenticate(email, tokenValue)) {
            User currUser = userRepo.findFirstByUserEmail(email);
            blogPost.setPostOwner(currUser);
            postService.addBlogPost(blogPost);
            return "post added";
        }
        //else return not authorised
        else {
            return "not a valid user";
        }
    }

    public Post getPostById(String email, String tokenValue, Long postId) {
        //verify the user
        if (authenticationService.authenticate(email, tokenValue)) {
            return postService.getPostById(postId);
        } else {
            return null;
        }

    }


    public String LikeThePost(String email, String tokenValue, Long postId) {
        //authenticate the user
        if (authenticationService.authenticate(email, tokenValue)) {
            //then get the user who is liking
            User likingUser = userRepo.findFirstByUserEmail(email);
            //find the post
            Post postToBeLiked = postService.postRepo.findById(postId).orElse(null);

            //check if user has already liked the post
            boolean likedOrNot = likeService.isAlreadyLiked(postToBeLiked, likingUser);
            if (!likedOrNot) {
                Likee newLike = new Likee(null, postToBeLiked, likingUser);
                likeService.saveLike(newLike);
                return "liked the post";
            } else {
                return "already liked post";
            }

        } else {
            return "not authorised to like the post";
        }

    }

    public String unlikeThePost(String email, String tokenValue, Long postId) {
        //authenticate user
        if (authenticationService.authenticate(email, tokenValue)) {
            //get the respective post and user
            User potentialLiker = userRepo.findFirstByUserEmail(email);

            Post blogPostToBeUnLiked = postService.getPostById(postId);
            return likeService.removeLikesByLikerAndPost(blogPostToBeUnLiked, potentialLiker);


        } else {
            return "not a valid user to unlike";
        }
    }

    public String getAllLikes(String email, String tokenValue, Long postId) {
        //authenticate first
        if (authenticationService.authenticate(email, tokenValue)) {

            Post blogPost = postService.getPostById(postId);

            return likeService.getLikesForPost(blogPost);

        } else {
            return "Un Authenticated access!!! to get likes ";
        }


    }

    public String commnetOnPost(String email, String tokenValue, String commentBody, Long postId) {

        //authenticate user for comment
        if (authenticationService.authenticate(email, tokenValue)) {

            //get the post where to be commented
            Post commentPost = postService.getPostById(postId);

            //then figure out commenter
            User commenter = userRepo.findFirstByUserEmail(email);

            //we can add more than one comment
            Comment newComment = new Comment(null, commentBody,
                    LocalDateTime.now(), commentPost, commenter);

            commentService.addComment(newComment);
            return "thanks for commenting";


        } else {
            return "not authorised to comment ";
        }
    }

    public String removeComment(String email, String tokenValue, Long commentId) {
        if (authenticationService.authenticate(email, tokenValue)) {
            //find the comment
            Comment dltComment = commentService.findCommnetById(commentId);

            //find the post
            Post currPost = dltComment.getInstaPost();
            //check id the post and the user belongs to  same user or not?
            if (authorizedChanger(email, currPost, dltComment)) {
                commentService.removeCommentById(commentId);
                return "comment deleted";
            } else {
                return "Not authorized!!";
            }

        } else {
            return "Un Authenticated access!!!";
        }


    }


    private boolean authorizedChanger(String email, Post currPost, Comment dltComment) {
        User potentialRemover = userRepo.findFirstByUserEmail(email);

        //only the changer and the owner of the post should be allowed to do any changes like updation,deletion

        return potentialRemover.equals(currPost.getPostOwner()) || potentialRemover.equals(dltComment.getCommenter());


    }


    public String updatePostInfo(String email, String tokenValue, Long postId,String updation) {
        //authenticate for user is valid or not
        if(authenticationService.authenticate(email,tokenValue)){

            //get post
            Post currPost=postService.getPost(postId);
            //get user by email
            User currUser=userRepo.findFirstByUserEmail(email);
            String currEmail=currUser.getUserEmail();

            //check user of passed email and user of post matches or not
            if(currPost.getPostOwner().getUserEmail().equals(currEmail)){
                currPost.setPostCaption(updation);
                postService.postRepo.save(currPost);
                return "details updated";

            }
            else{
                return " u are a user but not owner of this post";
            }


        }
        else{
            return "not a correct user";
        }
    }
}

