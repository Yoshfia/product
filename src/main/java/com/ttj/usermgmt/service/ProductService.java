package com.ttj.usermgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttj.usermgmt.domain.ProductDTO;
import com.ttj.usermgmt.domain.ProductEntity;
import com.ttj.usermgmt.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	public ProductEntity save(ProductDTO productDTO) {
		ProductEntity newProductEntity = new ProductEntity(); 
		newProductEntity.setName(productDTO.getName());
		newProductEntity.setPrice(productDTO.getPrice()); 
		return productRepo.save(newProductEntity); 	
	}
	public ProductEntity update(ProductDTO productDTO) {
		ProductEntity updateProductEntity = productRepo.findById(productDTO.getId()).get();
		updateProductEntity.setId(updateProductEntity.getId());
		updateProductEntity.setName(productDTO.getName());
		updateProductEntity.setPrice(productDTO.getPrice());
		return productRepo.save(updateProductEntity);
	}
	
	public void delete(Integer id) {
		productRepo.deleteById(id);
	}
	
	public List<ProductEntity> getList() {
		
		return productRepo.findAll();
		
	}
	public ProductEntity getProductById(Integer id) {
		
		return productRepo.findById(id).get();
	}
	
}
