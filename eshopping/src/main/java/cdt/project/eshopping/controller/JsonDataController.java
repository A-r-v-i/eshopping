package cdt.project.eshopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cdt.project.eshoppingbackend.dao.ProductDAO;
import cdt.project.eshoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	private ProductDAO productDAO;


	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {

		return productDAO.listActiveProducts();
	}

	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {

		return productDAO.listActiveProductByCategory(id);
	}
}
