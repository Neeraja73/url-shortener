package com.project.urlshortener.strategy;

public interface CodeGenerator {
    String generate(String longUrl);
}