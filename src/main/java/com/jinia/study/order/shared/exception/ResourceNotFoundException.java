package com.jinia.study.order.shared.exception;


import org.springframework.http.HttpStatus;

// 404 - 리소스 찾을수 없음
public class ResourceNotFoundException extends BusinessException{

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // for rest
    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.NOT_FOUND;
    };
    // for monitoring
    @Override
    public boolean isNecessaryToLog(){
        return false;
    };
}
