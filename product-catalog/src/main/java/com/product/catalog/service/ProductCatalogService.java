package com.product.catalog.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.catalog.dto.ProductDTO;
import com.product.catalog.entity.Product;
import com.product.catalog.mapper.ProductCatalogMapper;
import com.product.catalog.repository.ProductCatalogRepository;

@Service
public class ProductCatalogService {

	@Autowired
	private ProductCatalogRepository productCatalogRepository;

	@Autowired
	private ProductCatalogMapper productCatalogMapper;

	public ProductDTO save(ProductDTO productDTO) {
		return productCatalogMapper
				.convertEntityToDto(productCatalogRepository.save(productCatalogMapper.convertDtoToEntity(productDTO)));
	}

	public List<ProductDTO> fetchAll() {
		return productCatalogMapper
				.convertListOfEntitiesToDtos(productCatalogRepository.findAll());
	}
	
	@Transactional
	public ProductDTO deleteByProductName(String name) {
		Product product = Optional.ofNullable(productCatalogRepository.findByName(name))
					     .orElse(null);
		if(null != product) {
			productCatalogRepository.deleteByName(name);
			return productCatalogMapper
					.convertEntityToDto(product);
		}
		return null;
	}

}
