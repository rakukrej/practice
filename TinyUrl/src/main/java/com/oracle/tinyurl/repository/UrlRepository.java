package com.oracle.tinyurl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.oracle.tinyurl.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

	

}
