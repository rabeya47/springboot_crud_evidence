package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.ProductModel;
@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Integer> {

	
	@Query("SELECT p from ProductModel p where p.name like %:searchText% or p.id like %:searchText%")
	public List<ProductModel> serachProduct (String searchText);
}
