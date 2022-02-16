package com.sparta.board.post.service;

import com.sparta.board.post.dto.PostDto;
import com.sparta.board.post.dto.PostRequestDto;
import com.sparta.board.post.entity.Post;
import com.sparta.board.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
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

    public List<PostDto> getAll(){
        List<Post> all = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostDto> dto = all.stream()
                .map(post -> PostDto.from(post))
                .collect(Collectors.toList());
        return dto;
    }
}
