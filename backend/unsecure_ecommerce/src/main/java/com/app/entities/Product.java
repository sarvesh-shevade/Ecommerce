package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="products")

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude="reviewList")

public class Product extends BaseEntity {
	
	@Column(length = 50,nullable = false,unique = true)
	private String prod_Name;
	
	@Column(nullable = false)
	private Double prod_price;
	
	@Column(length=50,nullable = false)
	private String prod_Brand;
	
	@Enumerated(EnumType.STRING)
	@Column(length=100)
	private Category prod_category;
	
	@Column(length=2083,nullable = false)
	private String prod_image_url;
	
	@Column(columnDefinition = "TEXT" )
	@Lob
	private String prod_description;
	
	@Column 
	@Range(min=1,max=5)
	private float prod_rating;
	
	@Column
	@Range(min=0)
	private int prod_stockQty;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Reviews> reviewList;
	
	private int prod_reviewsCount;


	public Product(String prod_Name, Double prod_price, String prod_Brand, Category prod_category,
			String prod_image_url, String prod_description, int prod_stockQty,
			List<Reviews> reviewList) {
		super();
		this.prod_Name = prod_Name;
		this.prod_price = prod_price;
		this.prod_Brand = prod_Brand;
		this.prod_category = prod_category;
		this.prod_image_url = prod_image_url;
		this.prod_description = prod_description;
		this.prod_stockQty = prod_stockQty;
		this.reviewList = reviewList;
		
		int ratingSum = 0;
		this.prod_reviewsCount = this.reviewList.size();
		for(Reviews rev:this.reviewList)
		{
			ratingSum += rev.getRating();
		}
		this.prod_rating = ratingSum/this.prod_reviewsCount;
	}
	


	
	
}
