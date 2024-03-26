package com.snipe.let.admin.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.constants.Role;
import com.snipe.let.admin.domain.CartItemDomain;
import com.snipe.let.admin.exception.LetRestException.ROLE_NOT_FOUND;
import com.snipe.let.admin.exception.LetRestException.VALIDATE;
import com.snipe.let.admin.model.CartItemModel;
import com.snipe.let.admin.model.ProductsModel;

@Component
public class CartUtils {

	public List<CartItemDomain> validateCartInfo(CartItemModel cartItemModel) throws Exception {
		if (cartItemModel.getUserRoleId() == 0)
			throw new VALIDATE("Please Specify User Role");
		Role role = Role.getRole(cartItemModel.getUserRoleId() + "");
		if (role == null)
			throw new ROLE_NOT_FOUND(cartItemModel.getUserRoleId() + "");
		List<CartItemDomain> cartItemDomain = new ArrayList<CartItemDomain>();
		List<ProductsModel> productsModel = cartItemModel.getProductsModel();
		switch (role) {
		case CUSTOMER:
			for (ProductsModel product : productsModel) {
				if (product.getProductId() == 0)
					throw new VALIDATE("Please Enter Product Id");
				if (product.getQuantity() == null || product.getQuantity() == 0.0)
					throw new VALIDATE("Please Specify Quantity");
				if (cartItemModel.getUserId() == null || cartItemModel.getUserId().isEmpty())
					throw new VALIDATE("Please Enter UserId");
				CartItemDomain cartItem = new CartItemDomain();
				cartItem.setProductId(product.getProductId());
				cartItem.setQuantity(product.getQuantity());
				cartItem.setUserId(cartItemModel.getUserId());
				cartItem.setCategoryId(product.getCategoryId());
				cartItem.setCategoryTypeId(product.getCategoryTypeId());
				cartItem.setStatus(false);
				cartItem.setCount(cartItemModel.getCount());
				cartItemDomain.add(cartItem);
				
			}
			break;
		case RETAILER:
			for (ProductsModel product : productsModel) {
				if (product.getCategoryTypeId() == 0)
					throw new VALIDATE("Please Enter CategoryTypeId");
				if (product.getCategoryId() == 0)
					throw new VALIDATE("Please Enter CategoryId");
				if (product.getProductId() == 0)
					throw new VALIDATE("Please Enter Product Id");
				if (product.getQuality() == null || product.getQuality().isEmpty())
					throw new VALIDATE("Please Specify Quality");
				if (cartItemModel.getUserId() == null || cartItemModel.getUserId().isEmpty())
					throw new VALIDATE("Please Enter UserId");
				CartItemDomain cartItem = new CartItemDomain();
				cartItem.setProductId(product.getProductId());
				cartItem.setCategoryId(product.getCategoryId());
				cartItem.setCategoryTypeId(product.getCategoryTypeId());
				cartItem.setQuality(product.getQuality());
				cartItem.setUserId(cartItemModel.getUserId());
				cartItem.setQuantity(0.0);
				cartItem.setCount(0);
				cartItem.setStatus(false);
				cartItemDomain.add(cartItem);
			}
			break;
		default:
			break;
		}
		return cartItemDomain;

	}
	
	public List<CartItemDomain> updateCartInfo(CartItemModel cartItemModel) throws Exception {
		List<CartItemDomain> cartItemDomain = new ArrayList<CartItemDomain>();
			CartItemDomain cartItem = new CartItemDomain();
			cartItem.setCartItemId(cartItemModel.getCartItemId());
			cartItem.setCount(cartItemModel.getCount());
			cartItemDomain.add(cartItem);
		return cartItemDomain;
	}
}
