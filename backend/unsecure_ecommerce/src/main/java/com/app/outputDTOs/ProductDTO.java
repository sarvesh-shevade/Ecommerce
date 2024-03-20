package com.app.outputDTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class ProductDTO {
	
	private long prod_id;
	
	private String prod_Name;
	
	private Double prod_price;
	
	private String prod_Brand;
	
	private String prod_image_url;
	
	private float prod_rating;
	
	private int prod_reviewsCount ;
	
}
