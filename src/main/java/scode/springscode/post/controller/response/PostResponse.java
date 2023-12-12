package scode.springscode.post.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class PostResponse {

    private String author;

    private LocalDate createDate;

    private String title;

    private String body;
}
