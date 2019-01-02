package cdt.project.eshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cdt.project.eshoppingbackend.dao.CategoryDAO;
import cdt.project.eshoppingbackend.dao.ProductDAO;
import cdt.project.eshoppingbackend.dto.Category;
import cdt.project.eshoppingbackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome", true);
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		return mv;
	}
	
/*	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		if(greeting==null)
		{
			greeting="Hey fal!!";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
		
	}
*/
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;

	}
	
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {	
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
		
	}
	
	/*
	 * Methods to load  all the products
	 * */
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {	
		ModelAndView mv=new ModelAndView("page");
		
		//categoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
	    //passing single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;

	}
	
	/*Viewing single product*/
	
	@RequestMapping(value= "/show/{id}/product")
	public ModelAndView showingSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
				
		Product product = productDAO.get(id);
		
		//update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
	}

}
