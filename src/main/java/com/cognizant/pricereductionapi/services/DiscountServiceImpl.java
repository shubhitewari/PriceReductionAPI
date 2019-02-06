package com.cognizant.pricereductionapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cognizant.pricereductionapi.converter.ProductToProductModelConverter;
import com.cognizant.pricereductionapi.model.LabelTypeEnum;
import com.cognizant.pricereductionapi.model.ProductModel;
import com.cognizant.pricereductionapi.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DiscountServiceImpl implements DiscountService {
	private ProductToProductModelConverter productConverter = new ProductToProductModelConverter();
	
	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<ProductModel> getDiscountedProducts(Integer categoryId, Optional<LabelTypeEnum> priceLabelType) {
		
		List<ProductModel> productModels = discountRepository.getDiscountedProducts(categoryId).stream().map(product ->
								{ return productConverter.convert(product, priceLabelType);}
						).collect(Collectors.toList());
		
		return productModels;
	}

	

}
