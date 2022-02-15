package com.sparta.board.controller;

import com.sparta.board.domain.Post;
import com.sparta.board.domain.PostRepository;
import com.sparta.board.domain.PostRequestDto;
import com.sparta.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post>getPosts(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto requestDto){// 데이터를 몰고다니는놈 DTO
        Post post = new Post(requestDto); //
        return postRepository.save(post); //저장을하는 녀석은 repository
    }

    @GetMapping("/api/post/{id}")
    public Optional<Post> getPost(@PathVariable Long id){
        return postRepository.findById(id);
    }

    @PatchMapping("/api/post/{id}")
    public Long updatePost(@PathVariable Long id,@RequestBody PostRequestDto requestDto){
        System.out.println(requestDto);
        postService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long DeletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }


}
