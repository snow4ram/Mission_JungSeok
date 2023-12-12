package scode.springscode.post.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import scode.springscode.post.controller.request.PostRequest;
import scode.springscode.post.controller.response.PostResponse;

import scode.springscode.post.service.PostService;


@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService posts;

    @PostMapping("/write")
    public ResponseEntity<PostResponse> create(@Validated @RequestBody PostRequest writePost , HttpSession session) {

        log.info("세션 정보 = {}" ,session);

        PostResponse postResponse = new PostResponse(posts.write(writePost, session));

        return ResponseEntity.ok(postResponse);
    }

}
