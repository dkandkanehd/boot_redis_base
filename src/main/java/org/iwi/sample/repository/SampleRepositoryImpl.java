package org.iwi.sample.repository;

import org.iwi.sample.domain.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryImpl implements SampleRepository{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void save(Sample sample) {
		String key = "sample:1";
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, "id", sample.getId());
        hash.put(key, "name", sample.getName());
	}
	
	@Override
	public Sample getOne() {
		Sample sample = new Sample();
		String key = "sample:1";
		sample.setId((String)redisTemplate.opsForHash().get(key,"id"));
		sample.setName((String)redisTemplate.opsForHash().get(key,"name"));
		return sample;
	}
	
}
