package com.snipe.let.admin.dao;

import com.snipe.let.admin.domain.ProductDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductDao extends JpaRepository<ProductDomain,Long>{ 
	
    Optional<ProductDomain> findByProductNameIgnoreCase(String productName);
    
    Optional<ProductDomain> findByProductId(Long productId);

    @Query("SELECT p.subCategoriesId.subCategoriesId FROM ProductDomain p WHERE p.productId = :productId")
    Optional<Long> findSubCategoryIdByProductId(Long productId);

}
