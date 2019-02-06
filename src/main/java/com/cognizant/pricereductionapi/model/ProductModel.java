package com.cognizant.pricereductionapi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


@Data
public class ProductModel {
	
	private String id;
	private String title;
	private String nowPrice;
	private String priceLabel;
	private Float discount;
	private List<ColorSwatchModel> colorSwatches = new ArrayList<>();
	
}
