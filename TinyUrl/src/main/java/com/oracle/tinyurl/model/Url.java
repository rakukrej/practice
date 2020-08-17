package com.oracle.tinyurl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_COMPRESSED_URL")
public class Url {

	@Id
	@GeneratedValue
	@Column(name="real_url")
	private long short_url;
	@Column(name="short_url")
	private String real_url;
	public Url() {
		
	}
	@Override
	public String toString() {
		return "Url [short_url=" + short_url + ", real_url=" + real_url + "]";
	}
	public Url(long short_url, String real_url) {
		super();
		this.short_url = short_url;
		this.real_url = real_url;
	}
	public long getShort_url() {
		return short_url;
	}
	public void setShort_url(Long short_url) {
		this.short_url = short_url;
	}
	public String getReal_url() {
		return real_url;
	}
	public void setReal_url(String real_url) {
		this.real_url = real_url;
	}
	
}
