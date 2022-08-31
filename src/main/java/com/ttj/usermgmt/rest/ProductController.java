package com.ttj.usermgmt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.usermgmt.domain.ProductDTO;
import com.ttj.usermgmt.domain.ProductEntity;
import com.ttj.usermgmt.service.ProductService;


@RestController
@RequestMapping("/product/")
@RefreshScope
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("list")
	public List<ProductEntity> getList() {
		return productService.getList();
	}

	@PostMapping("create")
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO) {
		productService.save(productDTO);
		return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
	}

	@PostMapping("update")
	public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
		productService.update(productDTO);
		return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("getById/{id}")
	public ProductEntity getById(@PathVariable(value = "id") Integer id) {
		
		return productService.getProductById(id);

	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id) {
		productService.delete(id);
		return "Deleted";

	}

}
