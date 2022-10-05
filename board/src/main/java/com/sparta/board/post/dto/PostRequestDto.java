package com.sparta.board.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
}
