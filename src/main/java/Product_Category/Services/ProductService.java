package Product_Category.Services;

import Product_Category.Entity.Product;
import Product_Category.PaginationHelper.PaginationResponse;

public interface ProductService {
  
  	  public PaginationResponse<Product> getAllProduct(int page,int size);

	  Product createProduct(Product product);
	  Product getProductById(int id);
	  Product updateProduct(int id,Product product);
	  
	  String deleteProduct(int id);
	  
	  
	  
}
