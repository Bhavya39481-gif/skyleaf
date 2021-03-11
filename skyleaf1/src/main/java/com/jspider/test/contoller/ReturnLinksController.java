package com.jspider.test.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.test.bean.ReturnLinks;
import com.jspider.test.repository.ReturnLinksRepository;

@RestController
@RequestMapping("/returnlinks")
public class ReturnLinksController 
{
	private ReturnLinksRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<ReturnLinks> readAll()
	{
		Iterable<ReturnLinks> all=repository.findAll();
		
		return all;
	}

}
