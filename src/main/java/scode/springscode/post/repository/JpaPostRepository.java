package scode.springscode.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scode.springscode.post.entity.Post;

import java.util.Optional;

public interface JpaPostRepository  extends JpaRepository<Post , Long> {

    Optional<Post> findByTitle(String findTitle);
}
