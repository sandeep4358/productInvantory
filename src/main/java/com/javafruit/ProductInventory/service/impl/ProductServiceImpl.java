package com.javafruit.ProductInventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javafruit.ProductInventory.dto.ProductDTO;
import com.javafruit.ProductInventory.dto.RequestModel;
import com.javafruit.ProductInventory.dto.ResponseModel;
import com.javafruit.ProductInventory.entity.Product;
import com.javafruit.ProductInventory.repo.ProductRepository;
import com.javafruit.ProductInventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProduct() {
		log.info("entry");
		List<ProductDTO> productList = null;
		try {
			List<Product> allProduct = productRepository.findAll();
			allProduct.forEach(System.out::println);
			
			productList = allProduct.stream().map(i->ProductDTO.builder().price(i.getPrice()).title(i.getTitle()).description(i.getDescription()).imageUrl(i.getImageUrl()).build()).collect(Collectors.toList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		log.info("exit");
		return productList;
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editProduct(Product prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResponseModel saveProduct(RequestModel req) {
		log.info("enter");

		ProductDTO product = req.getProduct();
		ResponseModel res = new ResponseModel();
		Product prod = Product.builder().title(product.getTitle()).price(product.getPrice()).imageUrl(product.getImageUrl())
				.description(product.getDescription()).build();
		Product save = productRepository.save(prod);

		res.setData(save);
		res.setMessage("Product save successfully.");
		res.setStatus("00");

		log.info("exit");
		return res;
	}

}
