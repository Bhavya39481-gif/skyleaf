package com.jspider.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.jspider.test.bean.BillingDetails;

public interface BillingRepository extends CrudRepository<BillingDetails, String>{

}