package org.iwi.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

    public String getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
