package com.ibm.msreskill.product.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.msreskill.product.model.ProductCategory;
import com.ibm.msreskill.product.model.ProductInfo;
import com.ibm.msreskill.product.repository.ProductRepo;
import com.ibm.msreskill.product.utilities.GenSeq;

@Component
public class ProductDao {
	
	@Autowired
	ProductInfo productInfo;
	
	@Autowired
	ProductRepo productRepo;
	
	public String addProductInfo(ProductInfo product) {
		int productId = (int) GenSeq.getNext();
		productInfo.setProductId(productId);
		productInfo.setName(product.getName());
		productInfo.setPrice(product.getPrice());				
		productRepo.save(productInfo);
		return (productRepo.findById(productInfo.getProductId()) != null)?"success,productid : "+productInfo.getProductId():"error";
	}
	
	public String addProductTest() {
		int productId = (int) GenSeq.getNext();
		productInfo.setProductId(productId);
		productInfo.setName("apple");
		productInfo.setPrice(1.0);
		productInfo.setCategory(ProductCategory.FRUIT);
		productRepo.save(productInfo);
		return "testsuccess";
	}
	
	
	public List<ProductInfo> getproductInfoList() {
		List<ProductInfo> productList= new ArrayList<>();
		productRepo.findAll().forEach(productList::add);		
		return productList;
	}

}
