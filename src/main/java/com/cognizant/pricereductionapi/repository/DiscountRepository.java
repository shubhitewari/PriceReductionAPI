package com.cognizant.pricereductionapi.repository;

import java.util.List;

import com.cognizant.pricereductionapi.domain.Product;

public interface DiscountRepository {
	
	List<Product> getDiscountedProducts(Integer categoryId);

}
