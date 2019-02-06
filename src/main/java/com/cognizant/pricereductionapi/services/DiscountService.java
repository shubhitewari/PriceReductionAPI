package com.cognizant.pricereductionapi.services;

import java.util.List;
import java.util.Optional;

import com.cognizant.pricereductionapi.model.LabelTypeEnum;
import com.cognizant.pricereductionapi.model.ProductModel;

public interface DiscountService {

	List<ProductModel> getDiscountedProducts(Integer categoryId, Optional<LabelTypeEnum> priceLabelType);

}