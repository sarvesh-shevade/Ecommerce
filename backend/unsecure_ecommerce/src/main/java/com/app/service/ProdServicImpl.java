package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.entities.Product;
import com.app.outputDTOs.ProductDTO;
import com.app.outputDTOs.ProductDetailsDTO;

@Service
@Transactional
public class ProdServicImpl implements ProdService {
	
	@Autowired
	private ProductDao prodDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<ProductDTO> getProductList() {
		
		List<Product> list = prodDao.findAll();
	
		return list.stream()	
			.map(e->mapper.map(e, ProductDTO.class))
			.collect(Collectors.toList());
	}

	@Override
	public ProductDetailsDTO getProductDeatails(long id) {
		// TODO Auto-generated method stub
		return mapper.map(prodDao.findById(id),ProductDetailsDTO.class);
	}
	
	

}
