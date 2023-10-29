package nitish.bloggingapp.controller;

import nitish.bloggingapp.model.Likee;
import nitish.bloggingapp.model.Post;
import nitish.bloggingapp.model.User;
import nitish.bloggingapp.service.UserService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //singUp
    @PostMapping("user/signUp")
    public String userSignUp(@RequestBody User newUser) {
        return userService.userSignUp(newUser);
    }

    //signIn
    @PostMapping("user/signIn/{email}/{password}")
    public String userSignIn(@PathVariable String email, @PathVariable String password) {
        return userService.userSignIn(email, password);
    }


    //signOut
    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestParam String email, @RequestParam String token) {
        return userService.userSignOut(email, token);
    }

    //post API
    @PostMapping("blogPost")
    public String blogPost(@RequestParam String email, @RequestParam String tokenValue, @RequestBody Post blogPost) {
        return userService.addBlogPost(tokenValue, blogPost, email);
    }

    //get post by post id
    @GetMapping("post/id/{postId}")
    public Post getPostById(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId) {
        return userService.getPostById(email, tokenValue, postId);
    }

    //like Api
    @PostMapping("like/post/{postId}")
    public String likeThePost(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId) {
        return userService.LikeThePost(email, tokenValue, postId);
    }

    //unlike post api
    @DeleteMapping("like/post/{postId}")
    public String unlikeThePost(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId) {
        return userService.unlikeThePost(email, tokenValue, postId);
    }

    //count of likes on any post using post id
    @GetMapping("count/likes/{postId}")
    public String getTotalLikes(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId) {
        return userService.getAllLikes(email, tokenValue, postId);
    }
    //Comment API

    //post a comment
    @PostMapping("comment/post/{postId}")
    public String commentOnPost(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId, @RequestBody String commentBody) {
        return userService.commnetOnPost(email, tokenValue, commentBody, postId);
    }
    //delete comment
    @DeleteMapping("comment/post/{postId}")
    public String deleteComment(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long commentId){
        return userService.removeComment(email,tokenValue,commentId);

    }
    //update post caption
    @PutMapping("update/post/{postId}")
    public String updatePostDetails(@RequestParam String email, @RequestParam String tokenValue,@PathVariable Long postId,@RequestBody String updation){
        return userService.updatePostInfo(email,tokenValue,postId,updation);
    }
    //Api to delete a post
    @DeleteMapping("post")
    public String deletePost(@RequestParam String email, @RequestParam String tokenValue, @PathVariable Long postId){
        return userService.deletePost(email,tokenValue,postId);
    }



}
