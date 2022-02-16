package com.sparta.board.comment.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CommentRequestDto {
    private String username;

    @NotBlank(message = "내용을입력하세요")
    private String contents;
}

