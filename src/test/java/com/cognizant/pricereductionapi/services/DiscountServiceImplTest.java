package com.cognizant.pricereductionapi.services;

import com.cognizant.pricereductionapi.domain.Product;
import com.cognizant.pricereductionapi.model.ProductModel;
import com.cognizant.pricereductionapi.repository.DiscountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;



@RunWith(SpringRunner.class)
public class DiscountServiceImplTest {
	
	private static final Integer CATEGORY_ID = 123;
	
    @TestConfiguration
    static class DiscauntServicesImplTestContextConfiguration {

        @Bean
        public DiscountService discauntService() {
            return new DiscountServiceImpl();
        }
    }

    @Autowired
    private DiscountService discauntService;

    @MockBean
    private DiscountRepository discountRepository;

    @Before
    public void setUp() throws Exception {

        Mockito.when(discountRepository.getDiscountedProducts(CATEGORY_ID))
                .thenReturn(new ArrayList<Product>());
    }

    @Test
    public void get_productModels() {
        List<ProductModel> pms = discauntService.getDiscountedProducts(CATEGORY_ID, Optional.empty());
        assertTrue(pms.size()==0);
    }

	

}
