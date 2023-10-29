# API Documentation

Welcome to the documentation for the API, which provides endpoints for user management, blog posting, liking posts, following users, commenting, and more. This document outlines the available API endpoints and describes the data models used in the project.

## Table of Contents
- [API Endpoints](#api-endpoints)
- [Data Models](#data-models)
  - [AuthenticationToken](#authenticationtoken)
  - [User](#user)
  - [Post](#post)
  - [Like](#like)
  - [Follow](#follow)
  - [Comment](#comment)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## API Endpoints

The following is a list of available API endpoints and their descriptions:

1. **User Sign Up**
   - **Endpoint:** `POST /user/signUp`
   - **Description:** Allows users to sign up.

2. **User Sign In**
   - **Endpoint:** `POST /user/signIn/{email}/{password}`
   - **Description:** Enables users to sign in.

3. **User Sign Out**
   - **Endpoint:** `DELETE /user/signOut`
   - **Description:** Logs a user out.

4. **Post a Blog**
   - **Endpoint:** `POST /blogPost`
   - **Description:** Allows users to create and post a blog.

5. **Get Post by Post ID**
   - **Endpoint:** `GET /post/id/{postId}`
   - **Description:** Retrieves a specific blog post by post ID.

6. **Like a Post**
   - **Endpoint:** `POST /like/post/{postId}`
   - **Description:** Lets a user like a specific blog post.

7. **Unlike a Post**
   - **Endpoint:** `DELETE /like/post/{postId}`
   - **Description:** Allows a user to remove their like from a post.

8. **Count of Likes on a Post**
   - **Endpoint:** `GET /count/likes/{postId}`
   - **Description:** Retrieves the total number of likes on a specific post.

9. **Post a Comment**
   - **Endpoint:** `POST /comment/post/{postId}`
   - **Description:** Allows users to post a comment on a specific blog post.

10. **Delete Comment**
    - **Endpoint:** `DELETE /comment/post/{commentId}`
    - **Description:** Enables users to delete a comment based on the comment ID.

11. **Update Post Caption**
    - **Endpoint:** `PUT /update/post/{postId}`
    - **Description:** Allows users to update the caption or details of a specific post.

12. **Delete a Post**
    - **Endpoint:** `DELETE /post/{postId}`
    - **Description:** Allows users to delete a post based on the post ID.

13. **Follow a User**
    - **Endpoint:** `POST /follow/user/{targetUserId}`
    - **Description:** Allows a user to follow another user.

## Data Models

### AuthenticationToken
- **Fields:**
  - `tokenId` (Auto-generated)
  - `tokenValue` (string)
  - `tokenCreationDateTime` (timestamp)
  - `user` (User)
- **Description:** Represents an authentication token associated with a user session. The fields include:
  - `tokenId`: Automatically generated unique identifier for the token.
  - `tokenValue`: The value of the authentication token.
  - `tokenCreationDateTime`: The timestamp when the token was created.
  - `user`: The user associated with the token.

### User
- **Fields:**
  - `userId` (Auto-generated)
  - `userName` (string, required)
  - `userHandle` (string, required)
  - `userBio` (string)
  - `userEmail` (string, email)
  - `userPassword` (string)
  - `gender` (enum)
  - `accountType` (enum)
  - `blueTick` (boolean)
- **Description:** Represents a user in the system. The fields include:
  - `userId`: Automatically generated unique identifier for the user.
  - `userName`: The user's full name.
  - `userHandle`: A unique user handle or username.
  - `userBio`: A brief bio or description of the user.
  - `userEmail`: The user's email address, validated as an email.
  - `userPassword`: The user's password.
  - `gender`: The gender of the user, represented as an enum.
  - `accountType`: The type of user account, represented as an enum.
  - `blueTick`: A boolean indicating whether the user has a blue verification tick.

### Post
- **Fields:**
  - `postId` (Auto-generated)
  - `postContent` (string)
  - `postCaption` (string)
  - `postLocation` (string)
  - `postType` (enum)
  - `postCreatedTimeStamp` (timestamp)
  - `postOwner` (User)
- **Description:** Represents a blog post created by a user. The fields include:
  - `postId`: Automatically generated unique identifier for the post.
  - `postContent`: The content of the blog post.
  - `postCaption`: A brief caption or description for the post.
  - `postLocation`: The location associated with the post.
  - `postType`: The type of the post, represented as an enum.
  - `postCreatedTimeStamp`: The timestamp when the post was created.
  - `postOwner`: The user who owns the post.

### Like
- **Fields:**
  - `likeId` (Auto-generated)
  - `blogPost` (Post)
  - `liker` (User)
- **Description:** Represents a like action on a post by a user. The fields include:
  - `likeId`: Automatically generated unique identifier for the like action.
  - `blogPost`: The post that was liked.
  - `liker`: The user who liked the post.

### Comment
- **Fields:**
  - `commentId` (Auto-generated)
  - `commentBody` (string, required)
  - `commentCreationTimeStamp` (timestamp)
  - `blogPost` (Post)
  - `commenter` (User)
- **Description:** Represents a comment posted by a user on a blog post. The fields include:
  - `commentId`: Automatically generated unique identifier for the comment.
  - `commentBody`: The content of the comment.
  - `commentCreationTimeStamp`: The timestamp when the comment was created.
  - `blogPost`: The post on which the comment is posted.
  - `commenter`: The user who posted the comment.

### Follow
- **Fields:**
  - `followId` (Auto-generated)
  - `currentUser` (User)
  - `currentUserFollower` (User)
- **Description:** Represents a follower-following relationship between users. The fields include:
  - `followId`: Automatically generated unique identifier for the follow relationship.
  - `currentUser`:

