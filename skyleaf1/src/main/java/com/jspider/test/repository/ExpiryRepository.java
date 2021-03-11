package com.jspider.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspider.test.bean.CardExpiry;



public interface ExpiryRepository extends CrudRepository<CardExpiry, String>{

}
