package com.foodbox.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.services.*;
import com.foodbox.entities.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/cuisines")
public class CuisineController {
	
	//Properties
	private final CuisineService cuisineService;
	private final ProductService productService;

	//Constructor with Dependency Injection	
	public CuisineController(CuisineService cuisineService, ProductService productService) {		
		this.cuisineService = cuisineService;
		this.productService = productService;
	} 
	
	//REST Endpoints
	@GetMapping(path="/all")
	public ResponseEntity<List<Cuisine>> getAllCuisines(){
		List<Cuisine> allProducts = this.cuisineService.findAllCuisines();
		
		
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	@PostMapping(path="/add")
	public ResponseEntity<Cuisine> addCuisine(@RequestBody Cuisine cuisine){
		Cuisine newCuisine = cuisine;
		cuisineService.addCuisine(newCuisine);
		return new ResponseEntity<>(newCuisine, HttpStatus.CREATED);
	}
	
	/* Method to update Cuisine stored in the database */
	@PutMapping("/cuisine/update/{id}")
	public ResponseEntity<Cuisine> updateCuisineProductCount(@RequestBody Cuisine cuisine, @PathVariable("id") Long id){
		System.out.println("Cuisine Passed In:\n" + cuisine.toString());
		System.out.println("Id Passed In:" + id);
		Cuisine updatedCuisine = cuisineService.updateCuisine(cuisine);
		return new ResponseEntity<>(updatedCuisine, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/cuisine/delete/{id}")	
    public ResponseEntity<?> deleteTag(@PathVariable("id") Long id){
		cuisineService.deleteTag(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}//end class
