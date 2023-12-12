package scode.springscode.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scode.springscode.post.controller.request.PostRequest;
import scode.springscode.post.controller.request.PostUpdateRequest;
import scode.springscode.post.entity.Post;
import scode.springscode.post.repository.JpaPostRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    JpaPostRepository postRepository;

    @Override
    @Transactional
    public void create(PostRequest postRequest) {
        if (postRequest == null) {
            throw new RuntimeException("입력한 값이 없습니다.");
        }

        Post posts = Post.builder()
                .author(postRequest.getAuthor())
                .title(postRequest.getTitle())
                .createDate(LocalDate.now())
                .body(postRequest.getBody()).build();

        postRepository.save(posts);
    }

    @Override
    @Transactional
    public void update(Long updateId , PostUpdateRequest updateRequest) {
        Post post = postRepository
                .findById(updateId)
                .orElseThrow(() -> new RuntimeException(""));

        post.postUpdate(updateRequest);
    }

    @Override
    @Transactional
    public void delete(Long postId) {

        postRepository.deleteById(postId);

    }

    @Override
    @Transactional(readOnly = true)
    public void myList() {


    }

    @Override
    @Transactional(readOnly = true)
    public Post singleQuery(String findName) {
        return postRepository
                .findByTitle(findName)
                .orElseThrow(() -> new RuntimeException(""));

    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAllList() {

        return postRepository.findAll();

    }
}
