package com.sparta.board.comment.entity;

import com.sparta.board.comment.dto.CommentRequestDto;
import com.sparta.board.common.Timestamped;
import com.sparta.board.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;


    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;


    public Comment(String contents, String username){
        this.contents = contents;
        this.username = username;

    }

    public Comment(CommentRequestDto requestDto, Post post) {
        this.contents= requestDto.getContents();
        this.username = requestDto.getUsername();
        this.post = post;
    }

    public void update(CommentRequestDto requestDto){
        this.contents=requestDto.getContents();
        this.username=requestDto.getUsername();
    }
}
