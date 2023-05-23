package org.iwi.sample.service;

import javax.annotation.Resource;

import org.iwi.sample.domain.Sample;
import org.iwi.sample.repository.SampleRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	@Resource
	private SampleRepositoryImpl sampleRepository;
	
	//저장
	public void insertSample(Sample sample) {
		sampleRepository.save(sample);
	}
	
	//단건조회
	public Sample selectSampleOne() {
		return sampleRepository.getOne();
	}
}
