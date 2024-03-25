package com.app.outputDTOs;

import java.util.List;


import com.app.entities.Category;
import com.app.entities.Reviews;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDetailsDTO {
	
	private long prod_id;
	
	private String prod_Name;
	
	private Double prod_price;
	
	private String prod_Brand;
	

	private Category prod_category;
	
	private String prod_image_url;
	
	private String prod_description;
	
	private float prod_rating;
	
	private int prod_stockQty;
	
	private List<Reviews> reviewList;
	
	private int prod_reviewsCount;

}
