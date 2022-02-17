package com.sparta.board.comment.dto;

import com.sparta.board.comment.entity.Comment;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Builder

public class CommentDto {
    private Long id;
    private String username;


    private String contents;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .username(comment.getUsername())
                .contents(comment.getContents())
                .build();

    }

}


