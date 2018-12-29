package cdt.project.eshoppingbackend.dao;

import java.util.List;

import cdt.project.eshoppingbackend.dto.Product;

public interface ProductDAO {

	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Buisness methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int CategoryId);
	List<Product> getLatestActiveProducts(int count);
}
