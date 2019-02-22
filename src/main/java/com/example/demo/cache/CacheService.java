package com.example.demo.cache;

import com.example.demo.repository.SimpleRepo;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class CacheService {

    private Map<Integer, CacheObject> cache = new ConcurrentHashMap<>();
    private SimpleRepo repo;

    public CacheService(SimpleRepo repo) {
        this.repo = repo;
    }

    public Object get(Long id) {
        if (cache.containsKey(id) && cache.get(id).getCachedAt().isBefore(Instant.now())) {
            return cache.get(id).getObject();
        }
        Object object = repo.findById(id);
        if (object != null)
            putInCache(object, 10L);

        return object;
    }

    private void putInCache(Object ticket, Long presistanceTime) {
        cache.put(ticket.hashCode(), new CacheObject(ticket, presistanceTime));
    }
}
