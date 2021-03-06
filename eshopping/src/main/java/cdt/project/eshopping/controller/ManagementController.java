package cdt.project.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cdt.project.eshoppingbackend.dao.CategoryDAO;
import cdt.project.eshoppingbackend.dto.Category;
import cdt.project.eshoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		
		Product nProduct = new Product();
		
		//set few fields
		
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);
		
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mProduct) {
		
		return "redirect:/manage/products";
	}
	
	
	//returning categories
	@ModelAttribute("categories") 
	public List<Category> getCategories() {
		
		return categoryDAO.list();
	}
}
