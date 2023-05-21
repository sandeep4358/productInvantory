package com.javafruit.ProductInventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafruit.ProductInventory.dto.ProductDTO;
import com.javafruit.ProductInventory.dto.RequestModel;
import com.javafruit.ProductInventory.dto.ResponseModel;
import com.javafruit.ProductInventory.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	private Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService service;

	@GetMapping(value = "/inventory")
	public ResponseModel getInventory() {
		log.info("entry");
		ResponseModel res = new ResponseModel();

		try {
			res.setData(service.getAllProduct());
			res.setMessage("success");
			res.setStatus("00");
		} catch (Exception e) {
			res.setStatus("01");
			res.setMessage(e.getMessage());
		}
		
		return res;
	}
	
	@PostMapping(value = "/add")
	public ResponseModel add(@RequestBody RequestModel req) {
		ResponseModel res = new ResponseModel();
		try {
			res.setData(service.saveProduct(req));
			res.setMessage("success");
			res.setStatus("00");
		} catch (Exception e) {
			res.setStatus("01");
			res.setMessage(e.getMessage());
		}
		
		return res;
	}
	
	@PostMapping(value = "/fetchProductDetails")
	public ResponseEntity<List<ProductDTO>> getProductDetails(){
		log.info("enter..");
		List<ProductDTO> allProduct = service.getAllProduct();
		allProduct.forEach(System.out::println);
		log.info("exit..");
		return new ResponseEntity<List<ProductDTO>>(allProduct,HttpStatus.ACCEPTED);
	}

}
