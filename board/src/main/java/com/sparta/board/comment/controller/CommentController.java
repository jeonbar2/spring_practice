package com.sparta.board.comment.controller;

import com.sparta.board.comment.dto.CommentDto;
import com.sparta.board.comment.entity.CommentRepository;
import com.sparta.board.comment.service.CommentService;
import com.sparta.board.comment.dto.CommentRequestDto;
import com.sparta.board.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentService commentService;

    @GetMapping("api/comments/{postId}")
    public List<CommentDto> getComment(@PathVariable Long postId) {
        return commentService.getAll(postId);
    }

    //    @PostMapping("api/comments/{postId}")
//    public Long postComment(@PathVariable Long postId, @RequestBody CommentRequestDto requestDto){
//        return commentService.save(requestDto,postId);
//    }
    @PostMapping("api/comments/{postId}")
    public ResponseEntity<CommentDto> postComment(@PathVariable Long postId,@Valid @RequestBody CommentRequestDto requestDto) {
        CommentDto response=commentService.save(requestDto,postId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/comments/{commentId}")
    public Long updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto) {
        commentService.update(commentId, requestDto);
        return commentId;
    }


    @DeleteMapping("api/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
