package Product_Category.Controller;

import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Product_Category.Entity.Category;
import Product_Category.PaginationHelper.PaginationResponse;
import Product_Category.Services.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;  //create an object of service class
	
	// Get all categories with pagination
    @GetMapping("/categories")
    public ResponseEntity<PaginationResponse<Category>> getAllCategories(
        @RequestParam(defaultValue = "0") int page,//set the default page number and size 
        @RequestParam(defaultValue = "5") int size) { //if user not provided

        return new ResponseEntity<>(categoryService.getAllCategories(page, size),HttpStatus.OK);
    }

     //Create a new category
	 @PostMapping("/categories") 
	 public ResponseEntity<Category> createCategory(@RequestBody Category category){
		 
		return new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.CREATED);
		 
	 }
	 //Get category by ID
	 @GetMapping("/categories/{id}")  
	 public ResponseEntity<Category> getCategoryById(@PathVariable int id){
 	  
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
 		 
	 }
	 //Update category by ID
	 @PutMapping("/categories/{id}") 
	 public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
	   
		 return new ResponseEntity<>(categoryService.updateCategory(id, category),HttpStatus.OK);
	 
	 }
	 //Delete category by ID
     @DeleteMapping("/categories/{id}")
	 public ResponseEntity<String> deleteCategory(@PathVariable int id){
	
    	 return new ResponseEntity<>(categoryService.deleteCategory(id),HttpStatus.OK);
			 
	 }
	
	
	
}
