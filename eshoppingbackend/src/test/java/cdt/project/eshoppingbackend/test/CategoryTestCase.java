package cdt.project.eshoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cdt.project.eshoppingbackend.dao.CategoryDAO;
import cdt.project.eshoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("cdt.project.eshoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testCRUDCategory() {
		// add
		
		category = new Category();

		category.setName("Laptops");
		category.setDescription("Laptops for Geeks!");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully added this category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Mobile Phones");
		category.setDescription("Mobile yourself");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully added this category inside the table!", true, categoryDAO.add(category));

		// fetch & update
		category = categoryDAO.get(2);
		category.setName("Mobiles");

		assertEquals("Successfully updated a single category inside the table!", true, categoryDAO.update(category));

		// delete
		assertEquals("Successfully deleted a single category in the table!", true, categoryDAO.delete(category));

		// list
		assertEquals("Successfully fetched available category in the table!", 1, categoryDAO.list().size());

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptops");
	 * category.setDescription("Laptops for prove yourself");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Successfully added this category inside the table!",true,
	 * categoryDAO.add(category)); }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetched a single category inside the table!"
	 * ,"Mobile",category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(4); category.setName("TV");
	 * 
	 * assertEquals("Successfully updated a single category inside the table!",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(4);
	 * assertEquals("Successfully deleted a single category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched available category in the table!", 3,
	 * categoryDAO.list().size());
	 * 
	 * }
	 */

}