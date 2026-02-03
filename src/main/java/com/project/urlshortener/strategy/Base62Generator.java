package com.project.urlshortener.strategy;

import org.springframework.stereotype.Component;

@Component
public class Base62Generator implements CodeGenerator {

    @Override
    public String generate(String longUrl) {
        return Integer.toString(Math.abs(longUrl.hashCode()), 36);
    }
}
