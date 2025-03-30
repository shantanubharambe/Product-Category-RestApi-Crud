package Product_Category.Services;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Product_Category.Entity.Category;
import Product_Category.Entity.Product;
import Product_Category.PaginationHelper.PaginationResponse;
import Product_Category.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
	
    @Override
	public PaginationResponse<Category> getAllCategories(int page, int size) {
    	
    	// implements the pagination login
    	Pageable pageable = PageRequest.of(page, size);
    	
    	// Fetch paginated category data from the repository
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        
       
        PaginationResponse response = new PaginationResponse();

        // Set custom pagination info in the response
        response.setContent(categoryPage.getContent());
        response.setTotalPages(categoryPage.getTotalPages());
        response.setTotalElements(categoryPage.getTotalElements());
        response.setSize(categoryPage.getSize());
        response.setLast(categoryPage.isLast());
        response.setNumberOfElements(categoryPage.getNumberOfElements());
        
		return response;
	}
   
	@Override
	public Category createCategory(Category category) {
		
		// Implementing the bidirectional relationship logic
		List<Product>product=category.getProducts();
		
		// Create a new list to store updated products
		List<Product>list=new ArrayList<>();
		product.forEach(p->{
			  p.setCategory(category);
			  list.add(p);
		});
		category.setProducts(list);
		return  categoryRepository.save(category);
			
	}

	@Override
	public Category getCategoryById(int id) {
		// Find the category  by ID for get data by id 
		// If the ID is not found throw a RuntimeException
		return categoryRepository.findById(id)
			    .orElseThrow(() -> new RuntimeException("Category ID not found"));
	}

	@Override
	public Category updateCategory(int id, Category category) {
		// Find the Category by ID for updating data
		// If the ID is not found throw a RuntimeException
	 	   Category category1 = categoryRepository.findById(id)
				  .orElseThrow(() -> new RuntimeException("Category not found"));
		    
		   category1.setName(category.getName());  
		   return categoryRepository.save(category1);
		
	
		
	}

	@Override
	public String deleteCategory(int id) {
		// Find the Category by ID for deleting data
		// If the ID is not found throw a RuntimeException
		    Category o=categoryRepository.findById(id)
				 .orElseThrow(()->new RuntimeException("Category ID not found"));
		
			categoryRepository.delete(o);
			return "Category deleted successfully!";
	
	}
	
	

}
