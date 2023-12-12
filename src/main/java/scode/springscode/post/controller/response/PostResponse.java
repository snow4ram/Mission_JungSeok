package scode.springscode.post.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import scode.springscode.post.dto.PostDto;

import java.time.LocalDate;

@Getter
public class PostResponse {

    private Long id;

    private String author;

    private LocalDate createDate;

    private String title;

    private String body;

    public PostResponse(final PostDto postDto) {
        this.id = postDto.id();
        this.author = postDto.author();
        this.createDate = postDto.createDate();
        this.title = postDto.title();
        this.body = postDto.body();
    }
}
