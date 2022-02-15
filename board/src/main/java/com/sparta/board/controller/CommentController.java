package com.sparta.board.controller;

import com.sparta.board.domain.Comment;
import com.sparta.board.domain.CommentRepository;
import com.sparta.board.domain.CommentRequestDto;
import com.sparta.board.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    //@GetMapping("api/comments/{postId}")
    //public List<Comment> getComment(@PathVariable Long postId){return commentRepository.findAllByOrderModifiedAtDesc(postId);}

    @PostMapping("api/comments/{postId}")
    public Comment postComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }
}
