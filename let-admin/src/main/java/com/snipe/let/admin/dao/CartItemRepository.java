package com.snipe.let.admin.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.snipe.let.admin.domain.CartItemDomain;

public interface CartItemRepository extends JpaRepository<CartItemDomain, String> {


	public CartItemDomain findByCartItemId(String cartItemId);


	public CartItemDomain findByProductIdAndUserId(long productId, String userId);
	
	
	@Query("FROM CartItemDomain where userId=?1")
	public List<CartItemDomain> getCartItemsByUserId(String userId);

	@Query("FROM CartItemDomain where userId=?1 and categoryId=?2")
	public List<CartItemDomain> getCartItemsByUserAndCategoryId(String userId, long categoryId);

	@Query("FROM CartItemDomain where userId=?1 and categoryTypeId=?2")
	public List<CartItemDomain> getCartItemsByUserAndCategoryTypeId(String userId, long categoryTypeId);


	public List<CartItemDomain> getTotalPriceByUserId(String userId);


	




}
