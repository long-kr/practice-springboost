package com.bugblogs.bugsblog.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseDto<T> {

    private final String message;
    private final T data;

    public ResponseDto(String message, T data) {
        this.message = message;
        this.data = data;
    }

}
