package com.project.urlshortener.service;

import com.project.urlshortener.exception.UrlNotFoundException;
import com.project.urlshortener.model.UrlMapping;
import com.project.urlshortener.repository.UrlRepository;
import com.project.urlshortener.strategy.CodeGenerator;
import com.project.urlshortener.observer.AnalyticsService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UrlServiceImpl implements UrlService {

    private static final Logger log =
            LoggerFactory.getLogger(UrlServiceImpl.class);

    private final UrlRepository repository;
    private final CodeGenerator generator;
    private final AnalyticsService analyticsService;

    public UrlServiceImpl(UrlRepository repository,
                          CodeGenerator generator,
                          AnalyticsService analyticsService) {
        this.repository = repository;
        this.generator = generator;
        this.analyticsService = analyticsService;
    }

    @Override
    public String shortenUrl(String longUrl, long expiryAt) {

        log.info("Creating short URL for {}", longUrl);

        String code = generator.generate(longUrl);

        UrlMapping mapping = new UrlMapping();
        mapping.setShortCode(code);
        mapping.setLongUrl(longUrl);
        mapping.setCreatedAt(System.currentTimeMillis());
        mapping.setExpiryAt(expiryAt);
        mapping.setActive(true);

        repository.save(mapping);
        return code;
    }

    @Override
    public String redirect(String shortCode) {

        repository.cleanupExpired();

        log.info("Redirecting short code {}", shortCode);

        UrlMapping mapping = repository.find(shortCode);

        if (mapping == null) {
            throw new UrlNotFoundException("Short URL not found");
        }

        if (!mapping.isActive() || mapping.getExpiryAt() < System.currentTimeMillis()) {
            throw new UrlNotFoundException("URL expired or inactive");
        }


        analyticsService.recordClick(mapping);
        return mapping.getLongUrl();
    }

    @Override
    public void disable(String shortCode) {
        repository.delete(shortCode);
    }
}

