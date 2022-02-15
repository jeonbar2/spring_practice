package com.sparta.board.service;

import com.sparta.board.domain.Post;
import com.sparta.board.domain.PostRepository;
import com.sparta.board.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository; //꼭필요하다고 알려주기위해 final을 써주고 RequiredArgsConstructor를 어노테이션

    @Transactional  // DB에 직접 반영해야해 라고 알려주기위한 어노테이션션
   public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지않습니다.")
        );
        post.update(requestDto);
        return id;
    }
}
