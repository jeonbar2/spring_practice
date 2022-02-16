package com.sparta.board.common.error;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotValidResponse {
    private String field;
    private Object value;
    private String message;
}
