package com.snipe.let.admin.service;

import java.util.List;

import com.snipe.let.admin.domain.CartItemDomain;
import com.snipe.let.admin.model.CartItemModel;

public interface CartItemService {

	public List<CartItemDomain> saveCartItem(CartItemModel cartItemModel) throws Exception;

	public List<CartItemModel> getCartItems(String userId) throws Exception;

	public List<CartItemModel> getCartItem(String userId, long categoryId) throws Exception;

	public List<CartItemModel> getCartByCategoryType(String userId, long categoryTypeId) throws Exception;

	public CartItemDomain getCartItemsByProductId(long productId, String userId) throws Exception;

	public List<CartItemDomain> updateCart(CartItemModel cartItemModel) throws Exception;
	
	public String deleteCartById(String cartItemId) throws Exception;

	public CartItemModel getTotalPrice(String userId) throws Exception;
	
	public CartItemDomain getCartItemsById(String cartItemId) throws Exception;
	
	public long cartCount(String userId) throws Exception;


}
