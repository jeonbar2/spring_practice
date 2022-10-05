package com.sparta.board.post.controller;

import com.sparta.board.post.dto.PostDto;
import com.sparta.board.post.dto.PostRequestDto;
import com.sparta.board.post.service.PostService;
import com.sparta.board.post.entity.Post;
import com.sparta.board.post.entity.PostRepository;
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
    public List<PostDto>getPosts() {

        return postService.getAll();
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

    @PutMapping("/api/post/{id}")
    public Long updatePost(@PathVariable Long id,@RequestBody PostRequestDto requestDto){

        postService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long DeletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }


}
