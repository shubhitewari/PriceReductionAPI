package com.cognizant.pricereductionapi.controller;

import com.cognizant.pricereductionapi.model.LabelTypeEnum;
import com.cognizant.pricereductionapi.model.ProductModel;
import com.cognizant.pricereductionapi.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/discount")
public class PriceReductionController {
	
	@Autowired
	private DiscountService discountService;
	


    @GetMapping(value = "/products/{categoryId}")
	public List<ProductModel> getDiscountedProductsByCategoryId(@PathVariable(required = true) Integer categoryId, @RequestParam(required = false) LabelTypeEnum priceLabelType){
		
		Optional<LabelTypeEnum> labelType = Optional.ofNullable(priceLabelType);
		
		return discountService.getDiscountedProducts(categoryId, labelType);
	}

}
