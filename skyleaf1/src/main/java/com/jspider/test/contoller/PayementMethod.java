package com.jspider.test.contoller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jspider.test.bean.BillingDetails;
import com.jspider.test.bean.Card;
import com.jspider.test.bean.CardExpiry;
import com.jspider.test.bean.PaymentMethod;
import com.jspider.test.bean.ReturnLinks;
import com.jspider.test.repository.BillingRepository;
import com.jspider.test.repository.CardRepository;
import com.jspider.test.repository.ExpiryRepository;
import com.jspider.test.repository.PaymentRepository;
import com.jspider.test.repository.ReturnLinksRepository;


@RestController
@RequestMapping("/payment/method")
public class PayementMethod {

	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private BillingRepository billingRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private ExpiryRepository cardExpiryRepository;
	
	@Autowired
	private ReturnLinksRepository returnlinksrepository;

	@GetMapping("/readAll")
	public String readAll() 
	{
		Iterable<PaymentMethod> all = repository.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(all);

		JSONArray j1 = new JSONArray(json);
		JSONObject res = new JSONObject(j1.get(0).toString());

		Iterable<BillingDetails> billingResponse = billingRepository.findAll();

		json = gson.toJson(billingResponse);
		JSONObject billingJson = new JSONObject(new JSONArray(json).get(0).toString());
		res.put("BillingDetails", billingJson);

		// to get card

		Iterable<Card> cardResponse = cardRepository.findAll();

		json = gson.toJson(cardResponse);
		JSONObject cardJson = new JSONObject(new JSONArray(json).get(0).toString());
		// GET the card expiry
		Iterable<CardExpiry> cardExpiry = cardExpiryRepository.findAll();

		json = gson.toJson(cardExpiry);
		JSONObject cardExpiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("caredExpiry", cardExpiryJson);

		res.put("card", cardJson);
		
		Iterable<ReturnLinks> returnlinkResponse = returnlinksrepository.findAll();

		json = gson.toJson(returnlinkResponse);
//		JSONObject returnlinkJson = new JSONObject(new JSONArray(json).get(0).toString());
		
		res.put("ReturnLinks", new JSONArray(json));
		
		return res.toString();
	}

	@PostMapping("/create")
	public PaymentMethod create(@RequestBody PaymentMethod payment) {
		return repository.save(payment);
	}

	@PutMapping("/update")
	public PaymentMethod update(@RequestBody PaymentMethod payment) {
		return repository.save(payment);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}

}