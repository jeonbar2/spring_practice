package com.sparta.board.common.error;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}