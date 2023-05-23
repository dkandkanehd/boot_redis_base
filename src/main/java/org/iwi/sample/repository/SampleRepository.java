package org.iwi.sample.repository;

import org.iwi.sample.domain.Sample;

public interface SampleRepository {
	
	// 저장
	void save(Sample sample);
	
	// 단건 조회
	Sample getOne();
}
