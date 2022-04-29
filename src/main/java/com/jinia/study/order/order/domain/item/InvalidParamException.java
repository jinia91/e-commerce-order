package com.jinia.study.order.order.domain.item;

import com.jinia.study.order.shared.exception.InternalErrorException;

public class InvalidParamException extends InternalErrorException {
    public InvalidParamException() {
    }

    public InvalidParamException(String message) {
        super(message);
    }
}
