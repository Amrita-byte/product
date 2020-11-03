package com.ibm.msreskill.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.msreskill.product.model.ProductInfo;
import com.ibm.msreskill.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(path = "/producthome",method = RequestMethod.POST)
	public String getProductHome() {
		return "Welcome to product home page";
	}
	@RequestMapping(path = "/addProductInfo",method = RequestMethod.POST)
	public String addProductInfo(@RequestBody ProductInfo product) {
		return productService.addProductInfo(product);
		//return "Welcome to product home page";
	}	
	
	@RequestMapping(path = "/addProductTest",method = RequestMethod.POST)
	public String addProductTest() {
		return productService.addProductTest();
		//return "Welcome to product home page";
	}
	
	@RequestMapping(path = "/productInfoList",method = RequestMethod.POST)
	public List<ProductInfo> getproductInfoList() {		
		return productService.getproductInfoList();
	}
	
	@RequestMapping(path = "/productList",method = RequestMethod.POST)
	public List<ProductInfo> getproductList(@RequestHeader("Authorization") String jwtToken) 
			throws Exception{		
		return productService.getproductList(jwtToken);
	}
	
	@RequestMapping(path = "/validateHeaderToken",method = RequestMethod.POST)
	public Boolean validateHeaderToken(@RequestHeader("Authorization") String jwtToken) 
			throws Exception{		
		return productService.validateHeaderToken(jwtToken);
	}
	
	@RequestMapping(path = "/validateProduct",method = RequestMethod.POST)
	public Boolean validateProduct(@RequestBody int productId) 
			throws Exception{		
		return productService.validateProduct(productId);
	}

}
