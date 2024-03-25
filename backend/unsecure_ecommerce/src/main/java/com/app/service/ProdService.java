package com.app.service;

import java.util.List;


import com.app.outputDTOs.ProductDTO;
import com.app.outputDTOs.ProductDetailsDTO;


public interface ProdService  {
	
	
	public List<ProductDTO> getProductList();

	public ProductDetailsDTO getProductDeatails(long id);
	
	
	
}
