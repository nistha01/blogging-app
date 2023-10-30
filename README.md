# <p align ="center">  Blogging-application </p>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java-17-purple.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-blue.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.5-yellow.svg" />
</p>


## Overview
SpringBlogX is a versatile and user-friendly platform designed for bloggers and content creators of all levels. With a focus on simplicity, robust features, and a stunning user experience, our application empowers users to share their thoughts, stories, and expertise with the world.

## Frameworks And Languages:
The blogging apllication project is developed using the following frameworks and languages:

- Spring Boot: A Java-based framework for building web applications.
- Spring MVC: A module of the Spring Framework that supports building web applications.
- Java: The programming language used for backend development.
- Hibernate: An Object-Relational Mapping (ORM) framework used for database interactions.
- MySQL: The chosen database management system.

## Dependencies Used :
The dependencies used in the pom.xml file for this project are :

- Spring Starter Web: Provides essential web-related features and configurations.
- Spring JPA: Simplifies working with relational databases using Java Persistence API (JPA).
- Lombok: Reduces boilerplate code with annotations for getter, setter, and other common methods.
- Validation: Enables data validation using annotations.
- MySQL Driver: The chosen database management system for data storage.
- Swagger: To generate interactive API (documentation).

## Features

### User Management

1. **Sign Up:**
   - Users can register for an account with their information, including email and password.
   - It validates admin email addresses ending with "admin.com."

2. **Sign In:**
   - Registered users can sign in with their email and password, generating a unique token for authentication.

3. **Sign Out:**
   - Users can log out, which invalidates their token for security.
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
 
    ## Database Design:

The project uses MySQL as the database management system. To design the database for the post of the user, we need to consider the entities (tables) and their relationships. Based on the features and models mentioned in this file.
    
### Relationships:

- Each User can have multiple posts.
- Each posts can have multiple likes and comment.
- Each User can have like and comment other's post. But the post owner can edit or update the post.
- Each user can follow other user.

## Data Structure:

The project utilizes several data structures, including:

* Strings: Used for storing text-based data, such as user names, email addresses, phone numbers, post types, caption , post description and authentication tokens.
* Long: Used for storing numerical data, such as IDs.
* LocalDate: Used for storing date information, including token creation dates.
* ArrayList: To organize and manage data efficiently, such as lists of user,comment,like and followers.

## Deployment using AWS
Once developed and tested the music streaming app locally, next deployed it to a cloud platform like AWS (Amazon Web Services) to make it accessible to users worldwide. AWS provides a robust and scalable infrastructure to host web applications, making it a popular choice for deploying Spring Boot applications.

**Deployment Link** : [[http://65.2.150.67:8080/swagger-ui/index.html#/](http://3.110.188.154:8081/swagger-ui/index.html#/))

## Project Summary:
Blogging-application is a feature-rich and modern blogging platform built on the Spring Boot framework. This platform provides users with a seamless and interactive experience for creating, sharing, and engaging with blog posts. Key features and functionality include:User Registration and Authentication,Content CreationUser Management. And deployed the project using AWS(Amazon Web Service).

