package com.jspider.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspider.test.bean.Card;


public interface CardRepository extends CrudRepository<Card, String>{

}
