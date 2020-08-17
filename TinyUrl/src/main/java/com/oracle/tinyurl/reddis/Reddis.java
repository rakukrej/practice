package com.oracle.tinyurl.reddis;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.oracle.tinyurl.model.Url;
import com.oracle.tinyurl.repository.UrlRepository;

@Component
public class Reddis {
	
	@Autowired
	private Optional<Url> url;
	@Autowired
	private UrlRepository urlRepo;
	
	Map<Long,String> hm=new HashMap<>();
	
	public String getFromReddis(Long short_url) {
		if(hm.containsKey(short_url))
		{String long_url =hm.get(short_url);
		System.out.println("returning from reddis");
		return long_url;}
		return null;
	}
	public void putToReddis(Long short_url,String long_url) {
		hm.put(short_url,long_url);
		Url url=new Url();
		url.setReal_url(long_url);
		url.setShort_url(short_url);
		System.out.println("putting to reddis");
		urlRepo.saveAndFlush(url);
	}

}
