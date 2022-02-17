package com.sparta.board.comment.service;

import com.sparta.board.comment.dto.CommentDto;
import com.sparta.board.comment.dto.CommentRequestDto;
import com.sparta.board.comment.entity.Comment;
import com.sparta.board.comment.entity.CommentRepository;
import com.sparta.board.common.error.NotFoundException;
import com.sparta.board.post.entity.Post;
import com.sparta.board.post.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CommentService
{
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<CommentDto> getAll(Long postId){
        List<Comment> all = commentRepository.findAllByPostIdOrderByModifiedAt(postId);
        List<CommentDto> dto = all.stream()
                .map(comment->CommentDto.from(comment))
                .collect(Collectors.toList());
        return dto;
    }

    @Transactional
    public CommentDto save(CommentRequestDto requestDto, Long postId){

        Post post = postRepository.findById(postId).orElseThrow(

                ()-> {
                    System.out.println("a");
                    return new NotFoundException("포스트가 존재하지않습니다.");
                });

        Comment comment = new Comment(requestDto,post);
        System.out.println("as");
        Comment c = commentRepository.save(comment); //JPA가 저장한다음에 불러야 commentID가 생성됨됨

       return CommentDto.from(c);
    }
    @Transactional
    public Long update(Long commentId, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()->new NotFoundException("댓글이 없습니다.")
        );
        comment.update(requestDto);
        return commentId;
    }

    @Transactional
    public Long delete(Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
