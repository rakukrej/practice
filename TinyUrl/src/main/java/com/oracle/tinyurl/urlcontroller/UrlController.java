package com.oracle.tinyurl.urlcontroller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.tinyurl.exception.TinyUrlException;
import com.oracle.tinyurl.model.Url;
import com.oracle.tinyurl.service.UrlService;

@RestController
public class UrlController {
	

	@Autowired
 private UrlService urlservice;
	
	@GetMapping("/getreal/{shorturl}")
	public Url getReal_url(@PathVariable Long shorturl) throws TinyUrlException {
		return urlservice.getReal_url(shorturl);
		
	}
	
	@PostMapping("/generate")
	public Url generateShort_url(@RequestBody String realurl) {
		return urlservice.generateShort_url(realurl);
		
		
	}
}
