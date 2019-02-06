package com.cognizant.pricereductionapi.converter;

import com.cognizant.pricereductionapi.domain.ColorSwatch;
import com.cognizant.pricereductionapi.model.ColorSwatchModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ColorSwatchToColorSwatchModelConverterTest {

    ColorSwatchToColorSwatchModelConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new ColorSwatchToColorSwatchModelConverter();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new ColorSwatch()));
    }



}
