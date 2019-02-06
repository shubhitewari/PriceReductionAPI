package com.cognizant.pricereductionapi.converter;

import com.cognizant.pricereductionapi.domain.ColorSwatch;
import com.cognizant.pricereductionapi.model.ColorSwatchModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class ColorSwatchToColorSwatchModelConverter implements Converter<ColorSwatch, ColorSwatchModel> {

	@Override
	public ColorSwatchModel convert(ColorSwatch source) {
		
		if(source==null)
			return null;
		
		ColorSwatchModel target = new ColorSwatchModel();
		
		target.setColor(source.getColor());
		target.setSkuid(source.getSkuId());
		//TODO basic to rgb mapping
		target.setRgbColor(source.getBasicColor());
		
		return target;
	}

}
