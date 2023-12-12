package scode.springscode.post.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scode.springscode.post.controller.request.PostRequest;
import scode.springscode.post.controller.request.PostUpdateRequest;
import scode.springscode.post.dto.PostDto;
import scode.springscode.post.dto.PostMapperDto;
import scode.springscode.post.entity.Post;
import scode.springscode.post.repository.JpaPostRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final JpaPostRepository postRepository;
    private final PostMapperDto mapper;
    @Override
    @Transactional
    public PostDto write(PostRequest postRequest , HttpSession session) {

        if (postRequest == null) {
            throw new RuntimeException("입력한 값이 없습니다.");
        }

        Post posts = Post.builder()
                .author(postRequest.getAuthor())
                .title(postRequest.getTitle())
                .createDate(LocalDate.now())
                .body(postRequest.getBody()).build();

        postRepository.save(posts);

        return mapper.apply(posts);
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
    public PostDto singleQuery(final String findName) {

        Post post = postRepository
                .findByTitle(findName)
                .orElseThrow(() -> new RuntimeException(""));

        return mapper.apply(post);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAllList() {

        return postRepository.findAll();

    }
}
