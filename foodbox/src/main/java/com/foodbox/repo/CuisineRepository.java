package com.foodbox.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.entities.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	void deleteCuisineById(Long id);

}//end interface
