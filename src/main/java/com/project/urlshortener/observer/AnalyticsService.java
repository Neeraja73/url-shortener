package com.project.urlshortener.observer;

import com.project.urlshortener.model.UrlMapping;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    public void recordClick(UrlMapping mapping) {
        mapping.setClickCount(mapping.getClickCount() + 1);
    }
}

