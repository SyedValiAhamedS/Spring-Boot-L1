package com.product.catalog;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.product.catalog.entity.Product;
import com.product.catalog.repository.ProductCatalogRepository;

@DataJpaTest
class ProductCatalogApplicationTests {
	
	@Autowired
    private ProductCatalogRepository productCatalogRepository;

	 @Test
	 @Rollback(value = false)
	 public void deleteEmployeeTest(){
		 Product product = new Product("1X00","ABC",100.00,5);
		 productCatalogRepository.save(product);
		 
		 productCatalogRepository.deleteByName(product.getName());
		 
		 assertThat(productCatalogRepository.findByName(product.getName())).isNull();
	 }

}
