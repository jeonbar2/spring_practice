package com.sparta.board.post.dto;

import com.sparta.board.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@Builder

public class PostDto {
        private Long id;
        private String title;
        private String username;
        private String contents;

        public static PostDto from(Post post){
            return PostDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .username(post.getUsername())
                    .contents(post.getContents())
                    .build();
        }
}
