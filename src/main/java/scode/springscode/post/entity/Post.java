package scode.springscode.post.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import scode.springscode.member.entity.Member;
import scode.springscode.post.controller.request.PostUpdateRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private LocalDate createDate;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment = new ArrayList<>();

    @Builder
    public Post(String author, LocalDate createDate, String title, String body) {
        this.author = author;
        this.createDate = createDate;
        this.title = title;
        this.body = body;
    }

    public void postUpdate(PostUpdateRequest postUpdateRequest) {

        this.title = postUpdateRequest.getTitle();

        this.body = postUpdateRequest.getBody();
    }

    public void addUser(Member member) {

        if (this.member == null || this.member.equals(member)){
            if (this.member != null) {
                this.member.getPosts().remove(this);
            }

            //snow4ram/sbb-mission
        }
        this.member = member;

        if (member != null) {
            if (!member.getPosts().contains(this)) {
                member.getPosts().add(this);
            }
        }
    }
}
