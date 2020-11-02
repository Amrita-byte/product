package com.ibm.msreskill.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.msreskill.product.model.ProductInfo;

@Repository
public interface ProductRepo extends CrudRepository<ProductInfo, Integer>{

}
