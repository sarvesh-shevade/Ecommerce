package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reviews")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reviews extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="userEntity_id",nullable = false)
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product product;
	
	@Column(length=500)
	private String review;
	
	@Column
	@Range(min = 1,max = 5)
	private int rating;
	
	public void linkReviewToProduct(Product product)
	{
		product.getReviewList().add(this);
	}
	
	public void deLinkReviewToProduct(Product product)
	{
		product.getReviewList().remove(this);
	}
	
	public void linkReviewToUser(UserEntity user)
	{
		user.getReviews().add(this);
		
	}
	
	public void removeUser(UserEntity user)
	{
		user.getReviews().remove(this);
	}

}
