# My API Project

Welcome to the documentation for my API project. This project provides various API endpoints for user management, blog posting, commenting, liking posts, and more.

## Table of Contents
- [Overview](#overview)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

This API project is designed to facilitate user actions such as signing up, signing in, posting blogs, commenting on posts, and interacting with blog posts through liking, unliking, and more. It aims to provide a complete user and content management system.

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

## Getting Started

To get started with this API, you will need to set up your development environment and configure the necessary dependencies.

- Clone the repository: `git clone (https://github.com/nistha01/blogging-app)`
- Install dependencies: `install dependency`

## Usage

You can use the API endpoints by making HTTP requests to the specified URLs. Each endpoint has specific requirements for request parameters and request bodies. Detailed examples can be found in the code or documentation.

## Contributing

Contributions to this project are welcome. If you would like to report issues, suggest improvements, or submit pull requests, please follow the guidelines in the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## License

This project is licensed under the [License Name]. See the [LICENSE.md](LICENSE.md) file for more details.

