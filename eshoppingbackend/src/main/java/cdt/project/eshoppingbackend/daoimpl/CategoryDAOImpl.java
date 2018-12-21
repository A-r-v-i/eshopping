package cdt.project.eshoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cdt.project.eshoppingbackend.dao.CategoryDAO;
import cdt.project.eshoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories=new ArrayList<>();
	
	/* Adding categories in the list */
     
	static {
		
		Category category=new Category();
		
		category.setId(1);
		category.setName("Laptops");
		category.setDescription("Laptops for prove yourself");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category=new Category();

		category.setId(2);
		category.setName("Accessories");
		category.setDescription("Ready to SHOWOFF the FLOOR");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
        category=new Category();
        
		category.setId(3);
		category.setName("Apparels");
		category.setDescription("Casuals, Formals, Be Unique!");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category : categories){
			
			if(category.getId()==id)
			{
				return category;
			}
		}

		return null;
		
	}
	

}
