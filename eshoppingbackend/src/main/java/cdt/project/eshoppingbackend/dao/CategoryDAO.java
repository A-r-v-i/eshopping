package cdt.project.eshoppingbackend.dao;

import java.util.List;

import cdt.project.eshoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);

}
