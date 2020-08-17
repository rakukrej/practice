package com.oracle.tinyurl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.tinyurl.exception.TinyUrlException;
import com.oracle.tinyurl.model.Url;
import com.oracle.tinyurl.reddis.Reddis;
import com.oracle.tinyurl.repository.UrlRepository;

@Service
public class UrlService {
	
	
	@Autowired 
	private Reddis reddis;
	

	
	
	public Url getReal_url(Long short_url) throws TinyUrlException {
		
			String st= reddis.getFromReddis(short_url);
			Url u=new Url();
		if(st==null)
			
		{ Optional<Url> ur= null;
		if(ur.isPresent())
			 return ur.get();
		}
		u.setReal_url(st);
		u.setShort_url(short_url);
		return u;
		
		}

	public Url generateShort_url(String realurl) {
		Long sh=(long) (realurl.hashCode()%100000);
		Url url=new Url();
		url.setReal_url(realurl);
		url.setShort_url(sh);
		reddis.putToReddis(sh,realurl);
		
		return url;
	}

}
