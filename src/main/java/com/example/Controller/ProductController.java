package com.example.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.ProductModel;
import com.example.Repository.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo productRepo;
	
	
	@GetMapping("/show")
	public ModelAndView show() {
		Map <String,Object> map = new HashMap<String,Object>();
		List<ProductModel> productList =(List<ProductModel>) productRepo.findAll();
		map.put("productList", productList);
		
		return new ModelAndView("Product_show","data", map);
	}
	
	@GetMapping("/create")
	public ModelAndView create() {
		Map <String,Object> map = new HashMap<String,Object>();
		
		
		return new ModelAndView("Product_create","data", map);
	
}
	
	
	@PostMapping("/save")
	public ModelAndView save(@ModelAttribute ProductModel productModel, HttpServletRequest req) {
		Map <String,Object> map = new HashMap<String,Object>();
		try {
			productModel = productRepo.save(productModel);
			map.put("product", productModel);
			map.put("status","Success");
			map.put("message", "Product Saved Successfull");
		}catch(Exception e) {
			map.put("status","Failed");
			map.put("message", "Product Saved Failed");
		}
		
		return new ModelAndView("Product_create","data", map);
	
}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable (value = "id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		ProductModel product =  productRepo.findById(id).get();
		map.put("product", product);
		return new ModelAndView("Product_edit", "data", map);
	}
		
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute ProductModel productModel, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			productModel = productRepo.save(productModel);
			map.put("product", productModel);
			map.put("status", "Success");
			map.put("message", "Data updated successfully");
		} catch (Exception e) {
			map.put("status", "Failed");
			map.put("message", "Data updated failed");
		}
		return new ModelAndView("Product_edit", "data", map);
	
}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable (value = "id") int id) {
		Map <String,Object> map = new HashMap<String,Object>();
		try {
			ProductModel product = productRepo.findById(id).get();
			productRepo.delete(product);
			map.put("product", product);
		}catch(Exception e) {
			
		}
		
		return new ModelAndView("Product_show","data",map);
	}
	
	@GetMapping("/search")
	public ModelAndView search(@RequestParam(value = "searchText", required = false) String searchText) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(searchText == null || searchText.equals("")) {
			map.put("productList", new ArrayList<>());
			return new ModelAndView("Product_show", "data", map);
		}
		List<ProductModel> productList = productRepo.serachProduct(searchText);
		map.put("productList", productList);
		return new ModelAndView("Product_show", "data", map);
	}
	
}
