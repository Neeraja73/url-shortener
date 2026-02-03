package com.project.urlshortener.service;

public interface UrlService {
    String shortenUrl(String longUrl, long expiryAt);
    String redirect(String shortCode);
    void disable(String shortCode);
}
