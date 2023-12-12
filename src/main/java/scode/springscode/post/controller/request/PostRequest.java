package scode.springscode.post.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class PostRequest {

    private String author;

    private LocalDate createDate;

    private String title;

    private String body;
}
