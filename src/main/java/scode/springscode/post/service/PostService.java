package scode.springscode.post.service;

import jakarta.servlet.http.HttpSession;
import scode.springscode.post.controller.request.PostRequest;
import scode.springscode.post.controller.request.PostUpdateRequest;
import scode.springscode.post.dto.PostDto;
import scode.springscode.post.entity.Post;

import java.util.List;

public interface PostService {

    PostDto write(PostRequest postRequest , HttpSession session);

    void update(Long updateId , PostUpdateRequest updateRequest);

    void delete(Long postId);

    void myList();

    PostDto singleQuery(String findName);

    List<Post> findAllList();

}
