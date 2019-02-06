package com.cognizant.pricereductionapi.repository;

import java.util.List;

import com.cognizant.pricereductionapi.domain.Category;
import com.cognizant.pricereductionapi.domain.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DiscountRepositoryImpl implements DiscountRepository {

	@Override
	public List<Product> getDiscountedProducts(Integer categoryId) {
		
		RestTemplate restTemplate = new RestTemplate();
		//TODO: Move to yml file
		String resourceUrl = "https://jl-nonprod-syst.apigee.net/v1/categories/"+categoryId+"/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
		ResponseEntity<Category> response
		  = restTemplate.exchange(
				    resourceUrl ,
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<Category>(){});
		
		if(response.getStatusCode().is2xxSuccessful())
			log.info("Received Products: ",response.getBody().getProducts());
		
		
		return response.getBody().getProducts();
	}
	
	
	

}
