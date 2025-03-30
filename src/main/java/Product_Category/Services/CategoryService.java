package Product_Category.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Product_Category.Entity.Category;
import Product_Category.PaginationHelper.PaginationResponse;

public interface CategoryService {
   
  public PaginationResponse<Category> getAllCategories(int page,int size);

  Category createCategory(Category category);
  Category getCategoryById(int id);
  Category updateCategory(int id,Category category);
  
  String deleteCategory(int id);

  
   
  
  
  
  
  
  
  
 
	
}
