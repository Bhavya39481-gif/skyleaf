package com.jspider.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspider.test.bean.PaymentMethod;



public interface PaymentRepository extends CrudRepository<PaymentMethod, String>{

}