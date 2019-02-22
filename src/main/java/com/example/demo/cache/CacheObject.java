package com.example.demo.cache;

import lombok.Data;

import java.time.Instant;

@Data
public class CacheObject  {

    private Instant cachedAt;
    private Object object;

    public CacheObject(Object object, Long presistnaceTime) {
        this.cachedAt = Instant.now().plusSeconds(presistnaceTime);
        this.object = object;
    }
}
