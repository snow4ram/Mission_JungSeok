package scode.springscode.post.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class PostRequest {

    @NotEmpty
    private String author;

    @NotEmpty
    private String title;

    @NotEmpty
    private String body;
}
