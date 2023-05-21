package com.javafruit.ProductInventory.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ProductDTO {
	private int productId;
	private String title;
	private String description;
	private String imageUrl;
	private double price;
}
