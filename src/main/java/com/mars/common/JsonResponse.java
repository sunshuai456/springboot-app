package com.mars.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JsonResponse<T> {

    private ResponseStatus status = ResponseStatus.ERROR;

    private String message;

    private T data;
}
