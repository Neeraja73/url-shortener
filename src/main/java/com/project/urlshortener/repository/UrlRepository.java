package com.project.urlshortener.repository;

import com.project.urlshortener.model.UrlMapping;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@Repository
public class UrlRepository {

    private final Map<String, UrlMapping> store = new HashMap<>();

    private final Queue<String> expiryQueue = new LinkedList<>();

    public void save(UrlMapping mapping) {
        store.put(mapping.getShortCode(), mapping);

        expiryQueue.offer(mapping.getShortCode());
    }

    public UrlMapping find(String shortCode) {
        return store.get(shortCode);
    }

    public void delete(String shortCode) {
        store.remove(shortCode);
    }

    public void cleanupExpired() {
        while (!expiryQueue.isEmpty()) {
            UrlMapping m = store.get(expiryQueue.peek());
            if (m != null && m.getExpiryAt() < System.currentTimeMillis()) {
                store.remove(expiryQueue.poll());
            } else {
                break;
            }
        }
    }

}
