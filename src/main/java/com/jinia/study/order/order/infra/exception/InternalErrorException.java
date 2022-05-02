package com.jinia.study.order.order.infra.exception;


import org.springframework.http.HttpStatus;

// 인지된 500대 에러
public class InternalErrorException extends BusinessException{

    public InternalErrorException() {
    }

    public InternalErrorException(String message) {
        super(message);
    }

    // for rest
    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.INTERNAL_SERVER_ERROR;
    };
    // for monitoring
    @Override
    public boolean isNecessaryToLog(){
        return true;
    };
}
