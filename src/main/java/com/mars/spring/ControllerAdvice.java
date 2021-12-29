package com.mars.spring;

import com.mars.annotation.ResponseMessage;
import com.mars.common.JsonResponse;
import com.mars.common.ResponseStatus;
import com.mars.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice implements ResponseBodyAdvice {

    private final List<String> executeMethod = new ArrayList<>();

    public ControllerAdvice() {
        executeMethod.add("openapiJson");
        executeMethod.add("redirectToUi");
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResponse customException(Exception e) {
        JsonResponse jsonResponse = new JsonResponse();
        if (e instanceof IllegalArgumentException || e instanceof ServiceException) {
            jsonResponse.setMessage(e.getMessage());
        } else {
            log.error("系统错误：{}", e.getMessage());
            jsonResponse.setMessage("系统错误");
        }
        return jsonResponse;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if ("com.mars.common.JsonResponse".equals(returnType.getGenericParameterType().getTypeName()) ||
                executeMethod.indexOf(returnType.getMethod().getName()) != -1) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        JsonResponse<Object> jsonResponse = new JsonResponse<>();
        jsonResponse.setData(body);
        jsonResponse.setStatus(ResponseStatus.SUCCESS);
        jsonResponse.setMessage("操作成功");
        if (returnType.getMethodAnnotation(GetMapping.class) != null) {
            jsonResponse.setMessage(null);
        }
        ResponseMessage message = returnType.getMethodAnnotation(ResponseMessage.class);
        if (message != null) {
            jsonResponse.setMessage(message.value());
        }
        return jsonResponse;
    }
}
