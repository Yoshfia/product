package com.ttj.usermgmt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ttj.usermgmt.domain.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer>{

}
