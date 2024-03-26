package com.snipe.let.admin.controller;

import static com.snipe.let.admin.exception.HttpResponseUtils.prepareSuccessResponse;


import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snipe.let.admin.exception.GenericRes;
import com.snipe.let.admin.model.CartItemModel;
import com.snipe.let.admin.service.CartItemService;

@RestController
@RequestMapping("/v1")
@SuppressWarnings("rawtypes")
public class CartItemController {

	@Autowired
	CartItemService cartItemservice;

	@RequestMapping(value = "/save/cartItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> saveCartItem(@RequestBody CartItemModel cartItemModel) throws Exception {
		return prepareSuccessResponse(cartItemservice.saveCartItem(cartItemModel));
	}

	@RequestMapping(value = "/cartItems/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCartList(@PathVariable("userId") String userId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getCartItems(userId));
	}
	
	@RequestMapping(value = "/cartItemsById/{cartItemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCartItemsById(@PathVariable("cartItemId") String cartItemId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getCartItemsById(cartItemId));
	}

	@RequestMapping(value = "/cartItems/productId/{productId}/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCartItemsByProductId(@PathVariable("productId") long productId,@PathVariable("userId") String userId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getCartItemsByProductId(productId,userId));
	}

	@RequestMapping(value = "/cartItem/{userId}/{categoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCartItem(@PathVariable("userId") String userId,
			@PathVariable("categoryId") Long categoryId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getCartItem(userId, categoryId));
	}

	@RequestMapping(value = "/cartItem/categoryType/{userId}/{categoryTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getCartByCategoryType(@PathVariable("userId") String userId,
			@PathVariable("categoryTypeId") Long categoryTypeId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getCartByCategoryType(userId, categoryTypeId));
	}

	@RequestMapping(value = "/updateCart", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> updatecart(@RequestBody CartItemModel cartItemModel) throws Exception {
		return prepareSuccessResponse(cartItemservice.updateCart(cartItemModel));
	}
	
	@RequestMapping(value = "/deletecart/{cartItemId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> deleteCartById(@PathVariable("cartItemId") String cartItemId) throws Exception {
		return prepareSuccessResponse(cartItemservice.deleteCartById(cartItemId));
	}
	
	@RequestMapping(value = "/cart/totalPrice/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> getTotalPrice(@PathVariable("userId") String userId) throws Exception {
		return prepareSuccessResponse(cartItemservice.getTotalPrice(userId));
	}
	@RequestMapping(value = "/cartCount/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	@ResponseBody
	public ResponseEntity<GenericRes> cartCount(@PathVariable("userId") String userId) throws Exception {
		return prepareSuccessResponse(cartItemservice.cartCount(userId));
	}
}
