package org.iwi.sample.controller;

import org.iwi.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	 
	@GetMapping("/sampleList")
	public String sampleList(Model model) throws Exception{
		
		System.out.println(sampleService.getData("test"));
		
		return "sample/sampleList";
	}
	
}
