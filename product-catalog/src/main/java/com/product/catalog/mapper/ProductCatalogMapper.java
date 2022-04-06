package com.product.catalog.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.product.catalog.dto.ProductDTO;
import com.product.catalog.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductCatalogMapper {

	Product convertDtoToEntity(ProductDTO ProductDTO);
	
	ProductDTO convertEntityToDto(Product Product);
	
	List<ProductDTO> convertListOfEntitiesToDtos(List<Product> iterable);

}
