package com.product.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.catalog.entity.Product;


@Repository
public interface ProductCatalogRepository extends JpaRepository<Product, Long> {
	
	Product findByName(String name);
	
	Integer deleteByName(String name);

}

