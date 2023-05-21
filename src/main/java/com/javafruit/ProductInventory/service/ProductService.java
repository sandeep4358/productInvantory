package com.javafruit.ProductInventory.service;

import java.util.List;

import com.javafruit.ProductInventory.dto.ProductDTO;
import com.javafruit.ProductInventory.dto.RequestModel;
import com.javafruit.ProductInventory.dto.ResponseModel;
import com.javafruit.ProductInventory.entity.Product;

public interface ProductService {

	public List<ProductDTO> getAllProduct();

	public Product getProductById(Integer id);


	public boolean editProduct(Product prod);
	public ResponseModel saveProduct(RequestModel req);
}
