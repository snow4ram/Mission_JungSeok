package scode.springscode.post.dto;

import org.springframework.stereotype.Service;
import scode.springscode.post.entity.Post;

import java.util.function.Function;


@Service
public class PostMapperDto implements Function<Post, PostDto> {
    @Override
    public PostDto apply(Post post) {
        return new PostDto(post.getId(),post.getAuthor(),post.getCreateDate(),post.getTitle(),post.getBody());
    }
}
