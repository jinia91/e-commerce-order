package com.jinia.study.order.order.adapter.outgoing.persistence.token;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class TokenGeneratorImpl implements TokenGenerator {
    private static final int TOKEN_LENGTH = 20;

    @Override
    public String nextOneToken(String prefix) {
        return randomCharacterWithPrefix(prefix);
    }

    private String randomCharacter(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    private String randomCharacterWithPrefix(String prefix) {
        return prefix + randomCharacter(TOKEN_LENGTH - prefix.length());
    }
}