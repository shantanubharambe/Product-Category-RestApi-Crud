package Product_Category.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Product_Category.Entity.Category;
import Product_Category.Entity.Product;
import Product_Category.PaginationHelper.PaginationResponse;
import Product_Category.Services.CategoryService;
import Product_Category.Services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	    @Autowired
	    ProductService productService;  //create an object of service class
		
		// Get all Product with pagination
	    @GetMapping("/products")
	    public ResponseEntity<PaginationResponse<Product>> getAllProduct(
	        @RequestParam(defaultValue = "0") int page,//set the default page number and size 
	        @RequestParam(defaultValue = "5") int size) {//if user not provided

	  	 
	        return new ResponseEntity<>(productService.getAllProduct(page, size),HttpStatus.OK);
	    }
         
	     //Create a new Product
		 @PostMapping("/products")
		 public ResponseEntity<Product> createProduct(@RequestBody Product product){
			 
			return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
			 
		 }
		 
		//Get Product by ID
		 @GetMapping("/products/{id}")
		 public ResponseEntity<Product> getProductById(@PathVariable int id){
	 	   
			 return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
	 		 
		 }
		
		//Update product by ID
		 @PutMapping("/product/{id}")
		 public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		     
			 return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.OK);
		 
		 }
		 //Delete Product by ID
	     @DeleteMapping("/products/{id}")
		 public ResponseEntity<String> deleteProduct(@PathVariable int id){
		
	    	 return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
				 
		 }
		
		
		
	}
