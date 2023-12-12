package scode.springscode.post.service;

import scode.springscode.post.controller.request.PostRequest;
import scode.springscode.post.controller.request.PostUpdateRequest;
import scode.springscode.post.entity.Post;

import java.util.List;

public interface PostService {

    void create(PostRequest postRequest);

    void update(Long updateId , PostUpdateRequest updateRequest);

    void delete(Long postId);

    void myList();

    Post singleQuery(String findName);

    List<Post> findAllList();

}
