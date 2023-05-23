package org.iwi.sample.controller;

import javax.servlet.http.HttpServletRequest;

import org.iwi.sample.domain.Sample;
import org.iwi.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	 
	@GetMapping("/sampleWrite")
	public String sampleWrite(Model model) throws Exception{
		return "sample/sampleWrite";
	}
	
	@GetMapping("/sampleView")
	public String sampleView(Model model) throws Exception{
		
		// 단건조회
		Sample sample = sampleService.selectSampleOne();
		model.addAttribute("sample", sample);
		
		return "sample/sampleView";
	}
	
	@PostMapping("/insertSample")
	@ResponseBody
	public String insertSample(HttpServletRequest request
								, @ModelAttribute("sample")Sample sample) throws Exception{
		String result = "false";
		
		// 샘플 등록
		try {
			//insert 문
			sampleService.insertSample(sample);
			result = "success";
		} catch (Exception e) {
			System.out.println("error = " + e);
		}
		
		return result;
	}
}
