package com.snipe.let.admin.mapper;

import org.springframework.stereotype.Component;

import com.snipe.let.admin.domain.CartItemDomain;
import com.snipe.let.admin.model.CartItemModel;

@Component
public class CartItemMapper extends AbstractModelMapper<CartItemModel, CartItemDomain> {

	@Override
	public Class<CartItemModel> entityType() {
		// TODO Auto-generated method stub
		return CartItemModel.class;
	}

	@Override
	public Class<CartItemDomain> modelType() {
		// TODO Auto-generated method stub
		return CartItemDomain.class;
	}

}
