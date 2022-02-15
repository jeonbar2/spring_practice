package com.sparta.board.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class PostRequestDto {
    private String title;
    private String username;
    private String contents;
}
