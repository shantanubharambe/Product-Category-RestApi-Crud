package Product_Category.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Product_Category.Entity.Category;
import Product_Category.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	Page<Product> findAll(Pageable pageable);
}
