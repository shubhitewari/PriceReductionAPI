package com.cognizant.pricereductionapi.domain;

import java.util.List;

import lombok.Data;

@Data
public class Category {
	
	private List<Product> products;
	
}
