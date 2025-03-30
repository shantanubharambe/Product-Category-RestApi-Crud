package Product_Category.Services;
			
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Product_Category.Entity.Category;
import Product_Category.Entity.Product;
import Product_Category.PaginationHelper.PaginationResponse;
import Product_Category.Repository.CategoryRepository;
import Product_Category.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
   @Autowired
   ProductRepository productRepository;
   @Autowired
   CategoryRepository categoryRepository;
   
	@Override
	public PaginationResponse<Product> getAllProduct(int page,int size) {
            
		  // implements the pagination login
		   PageRequest pageable = PageRequest.of(page,size);
		  
		   // Fetch paginated product data from the repository
		   Page<Product> p = productRepository.findAll(pageable);
		   
	        // Set custom pagination info in the response
		   PaginationResponse response=new PaginationResponse();
	        
		    response.setContent(p.getContent());
	        response.setTotalPages(p.getTotalPages());
	        response.setTotalElements(p.getTotalElements());
	        response.setSize(p.getSize());
	        response.setLast(p.isLast());
	        response.setNumberOfElements(p.getNumberOfElements());
	        
			return response;
		   
	}

	@Override
	public Product createProduct(Product product) {
	    //fetch the category id for the check category present or not
		int id = product.getCategory().getId();
	    
	    if (id != 0) {
	       
	    	//get all category data by the id for set category details
	        Category c = categoryRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Category ID not found"));
	        //set a category details 
	        product.setCategory(c);
	    } else
	    {
	    	return null;
	    }
	    //save all data
	    return productRepository.save(product);
	}


	@Override
	public Product getProductById(int id) {
		// Find the product by ID for get data by id 
		// If the ID is not found  throw a RuntimeException
		return productRepository.findById(id)
			    .orElseThrow(() -> new RuntimeException("product ID not found"));

	}

	@Override
	public Product updateProduct(int id, Product product) {
		// Find the Product by ID for updating data
		// If the ID is not found throw a RuntimeException

	    Product po = productRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product ID not found"));

	    Category c = categoryRepository.findById(product.getCategory().getId())
	            .orElseThrow(() -> new RuntimeException("Category ID not found"));

	    po.setName(product.getName());
	    po.setPrice(product.getPrice());
	    po.setCategory(c); 
	    
	    return productRepository.save(po);
	}

 
	@Override
	public String deleteProduct(int id) {
		// Find the product by ID for deleting data
		// If the ID is not found throw a RuntimeException
		 Product po= productRepository.findById(id)
				.orElseThrow(()->new RuntimeException("Product ID not found"));
		
		 productRepository.delete(po);
		 return "Product deleted successfully!";
				
	}

}
