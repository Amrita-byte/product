package com.ibm.msreskill.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ibm.msreskill.product.dao.ProductDao;
import com.ibm.msreskill.product.model.ProductCategory;
import com.ibm.msreskill.product.model.ProductInfo;
import com.ibm.msreskill.product.repository.ProductRepo;
import com.ibm.msreskill.product.utilities.GenSeq;


@Service
public class ProductService {
	
	@Autowired
	ProductInfo productInfo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	AccountloginFeignClient accountLoginFeignClient;
	
	public String addProductInfo(ProductInfo product) {	
		setProductCategory(product.getCategory().toString());
		return productDao.addProductInfo(product);
	}
	public String addProductTest() {		
		return productDao.addProductTest();
	}
	public List getproductInfoList() {		
		return productDao.getproductInfoList();
	}
	
	public void setProductCategory(String category) {
		if (category == "Fruit" || category == "FRUIT" || category == "fruit")
		productInfo.setCategory(ProductCategory.FRUIT);	
		else if (category == "Veg" || category == "VEG" || category == "veg")
		productInfo.setCategory(ProductCategory.VEGETABLES);
		else if (category == "Bakery" || category == "BAKERY" || category == "bakery")
		productInfo.setCategory(ProductCategory.BAKERY);
		else if (category == "Drinks" || category == "DRINKS" || category == "drinks")
		productInfo.setCategory(ProductCategory.DRINKS);
		else if (category == "Veg" || category == "VEG" || category == "veg")
		productInfo.setCategory(ProductCategory.VEGETABLES);
		else
		productInfo.setCategory(ProductCategory.OTHERS);		
		
	}
	
	public List<ProductInfo> getproductList(String jwtToken) {
		// TODO Auto-generated method stub
		if(validateHeaderToken(jwtToken))			
			return getproductInfoList();
		else 
			return null;
	}
	public Boolean validateHeaderToken(String jwtToken) {
		// TODO Auto-generated method stub
		return accountLoginFeignClient.validateHeaderToken(jwtToken);
		
	}
	public Boolean validateProduct(int productId) {
		// TODO Auto-generated method stub
		if (productDao.getProduct(productId) != null)
		return true;
		else 
		return false;
	}


}
