package com.project.urlshortener.model;

public class UrlMapping {

        private String shortCode;
        private String longUrl;
        private long createdAt;
        private long expiryAt;
        private int clickCount;
        private boolean active;

        public String getShortCode() {
            return shortCode;
        }

        public void setShortCode(String shortCode) {
            this.shortCode = shortCode;
        }

        public String getLongUrl() {
            return longUrl;
        }

        public void setLongUrl(String longUrl) {
            this.longUrl = longUrl;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public long getExpiryAt() {
            return expiryAt;
        }

        public void setExpiryAt(long expiryAt) {
            this.expiryAt = expiryAt;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

