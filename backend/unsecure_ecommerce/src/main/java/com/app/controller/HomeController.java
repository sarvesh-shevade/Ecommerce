package com.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.app.outputDTOs.ApiResponse;
import com.app.service.ProdService;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:3000/")
public class HomeController {
	
	@Autowired
	private ProdService prodService;
	
	
	// any one should be able view the products
	@GetMapping("/getList")
	public ResponseEntity<?> viewProducts() {
		
	return ResponseEntity.status(HttpStatus.OK).body(prodService.getProductList());
	}
	
	@GetMapping("/getPrdouctDetails/{id}")
	public ResponseEntity<?> viewSingleProduct(@RequestParam long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(prodService.getProductDeatails(id));
		
	}



}
