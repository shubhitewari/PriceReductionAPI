package com.cognizant.pricereductionapi.converter;

import com.cognizant.pricereductionapi.domain.Price;
import com.cognizant.pricereductionapi.domain.Product;
import com.cognizant.pricereductionapi.model.LabelTypeEnum;
import com.cognizant.pricereductionapi.model.ProductModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
public class ProductToProductModelConverter {

    public ProductModel convert(Product source, Optional<LabelTypeEnum> labelType) {

        if (source == null)
            return null;

        String priceLabel = getPriceLabel(labelType, source.getPrice());

        log.info("product id {}", source.getProductId());


        ProductModel target = new ProductModel();

        target.setId(source.getProductId());
        target.setTitle(source.getTitle());
        target.setPriceLabel(priceLabel);
        target.setNowPrice(nowPrice(source.getPrice()));


        log.info("product {}", target);

        return target;

    }


    private String nowPrice(Price price) {
        Float nowPrice;

        try {
            nowPrice = Float.parseFloat((String) price.getNow());
        } catch (Exception e) {
            nowPrice = 1.23f;
        }
        return nowPrice < 10 ? price.getCurrency().getResponse() + Math.round(nowPrice) : price.getCurrency().getResponse() + nowPrice;
    }


    private String getPriceLabel(Optional<LabelTypeEnum> labelType, Price price) {

        String response = new String();

        LabelTypeEnum priceLabel = labelType.map(x -> {
            return x;
        }).orElse(LabelTypeEnum.ShowWasNow);

        if (LabelTypeEnum.ShowWasNow.equals(priceLabel)) {

            response = price.getWas().map(x -> {
                return "Was " + price.getCurrency().getResponse() + x + ", now " + nowPrice(price);
            }).orElse("Was " + nowPrice(price) + ", now " + nowPrice(price));

        } else if (LabelTypeEnum.ShowWasThenNow.equals(priceLabel)) {
            Optional<Float> then = (price.getThen2() != null ? price.getThen2() : (price.getThen1() != null ? price.getThen1() : Optional.empty()));
            if (then.isPresent())
                response = "Was " + price.getCurrency().getResponse() + price.getWas() + ", then " + price.getCurrency().getResponse() + then + ", now " + nowPrice(price);
            else
                response = "Was " + price.getCurrency().getResponse() + price.getWas() + ", now " + nowPrice(price);
        } else if (LabelTypeEnum.ShowPercDscount.equals(priceLabel))
            response = getDiscountPercentange(Float.parseFloat(price.getNow().toString()), price.getWas().get()) + "% off - now " + nowPrice(price);


        return response;
    }


    private int getDiscountPercentange(Float nowPrice, Float beforePrice) {
        return Math.round(((beforePrice - nowPrice) / beforePrice) * 100);
    }


}
