package com.product.catalog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.catalog.dto.ProductDTO;
import com.product.catalog.service.ProductCatalogService;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {

	@Autowired
	private ProductCatalogService productCatalogService;

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> saveProducts(@RequestBody ProductDTO productDTO) {
		return Optional.ofNullable(productCatalogService.save(productDTO))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}
	
	@GetMapping(value="/fetch-all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDTO>> fetchAll() {
		return Optional.ofNullable(productCatalogService.fetchAll())
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping(value="/delete", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> deleteByOrgName(@RequestParam String name) {

		return Optional.ofNullable(productCatalogService.deleteByProductName(name))
				.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
}
