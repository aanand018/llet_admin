package com.snipe.let.admin.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.snipe.let.admin.dao.CartItemRepository;
import com.snipe.let.admin.dao.SubCategoriesDAO;
import com.snipe.let.admin.dao.SubCategoriesImageDAO;
import com.snipe.let.admin.domain.CartItemDomain;
import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.domain.SubCategoriesImageDomain;
import com.snipe.let.admin.model.CartItemModel;
import com.snipe.let.admin.model.ProductsModel;
import com.snipe.let.admin.utils.CartUtils;
import com.snipe.let.admin.utils.IDGeneration;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	IDGeneration idGeneration;

	@Autowired
	CartUtils cartUtils;

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	SubCategoriesImageDAO subCategoriesImageDAO;

	@Autowired
	SubCategoriesDAO subCategoriesDAO;

	@Override
	public List<CartItemDomain> saveCartItem(CartItemModel cartItemModel) throws Exception {
		List<CartItemDomain> cartItemDomain = new ArrayList<CartItemDomain>();
		cartItemDomain = cartUtils.validateCartInfo(cartItemModel);
		for (CartItemDomain cart : cartItemDomain) {
			cart.setCartItemId(idGeneration.generateRandomNumber());
			cartItemRepository.save(cart);
		}
		return cartItemDomain;
	}
	
	@Override
	public List<CartItemModel> getCartItems(String userId) throws Exception {
		List<CartItemDomain> cartItemDomain = cartItemRepository.getCartItemsByUserId(userId);
		List<CartItemModel> cartItemModel = new ArrayList<CartItemModel>();
		SubCategoriesDomain subCategories = new SubCategoriesDomain();
		SubCategoriesImageDomain subCategoriesImageDomain = new SubCategoriesImageDomain();
		Double totalAmount = 0.0;
		for (CartItemDomain cartItem : cartItemDomain) {
			List<ProductsModel> productsModel = new ArrayList<ProductsModel>();
			ProductsModel product = new ProductsModel();
			CartItemModel cartItemM = new CartItemModel();
			BeanUtils.copyProperties(cartItem, cartItemM);
			product.setProductId(cartItem.getProductId());
			product.setQuantity(cartItem.getQuantity());
			product.setCategoryId(cartItem.getCategoryId());
			product.setCategoryTypeId(cartItem.getCategoryTypeId());
			subCategories = subCategoriesDAO.getSubCategoriesById(cartItem.getProductId());
			subCategoriesImageDomain = subCategoriesImageDAO.getSubCategoriesImageById(cartItem.getProductId());
			cartItemM.setProductName(subCategories.getSubCategoriesName());
			product.setAmount(subCategories.getPrice());
			long Qncount = cartItem.getCount();
			Double QnAmount = subCategories.getPrice();
			totalAmount = totalAmount + (QnAmount * Qncount);
			product.setTotalPrice(totalAmount);
			cartItemM.setProductImage(subCategoriesImageDomain.getName());
			productsModel.add(product);
			cartItemM.setProductsModel(productsModel);
			cartItemModel.add(cartItemM);
		}
		return cartItemModel;
	}

	public CartItemModel getTotalPrice(String userId) throws Exception {
		List<CartItemDomain> cartItemDomain = cartItemRepository.getTotalPriceByUserId(userId);
		CartItemModel cartItemModel = new CartItemModel();
		SubCategoriesDomain subCategories = new SubCategoriesDomain();
		Double totalAmount = 0.0;
		for (CartItemDomain cartItem : cartItemDomain) {
			ProductsModel product = new ProductsModel();
			CartItemModel cartItemM = new CartItemModel();
			BeanUtils.copyProperties(cartItem, cartItemM);
			subCategories = subCategoriesDAO.getSubCategoriesById(cartItem.getProductId());
			product.setAmount(subCategories.getPrice());
			long Qncount = cartItem.getCount();
			Double QnAmount = subCategories.getPrice();
			totalAmount = totalAmount + (QnAmount * Qncount);
		}
		cartItemModel.setTotalAmount(totalAmount);
		return cartItemModel;

	}

	@Override
	public CartItemDomain getCartItemsByProductId(long productId, String userId) throws Exception {
		CartItemDomain cartItemDomain = cartItemRepository.findByProductIdAndUserId(productId, userId);
		return cartItemDomain;
	}

	@Override
	public CartItemDomain getCartItemsById(String cartItemId) throws Exception {
		CartItemDomain cartItemDomain = cartItemRepository.findByCartItemId(cartItemId);
		return cartItemDomain;
	}

	@Override
	public List<CartItemModel> getCartItem(String userId, long categoryId) throws Exception {
		List<CartItemDomain> cartItemDomain = cartItemRepository.getCartItemsByUserAndCategoryId(userId,  categoryId);
		List<CartItemModel> cartItemModel = new ArrayList<CartItemModel>();
		SubCategoriesDomain subCategories = new SubCategoriesDomain();
		SubCategoriesImageDomain subCategoriesImageDomain = new SubCategoriesImageDomain();

		for (CartItemDomain cartItem : cartItemDomain) {
			List<ProductsModel> productsModel = new ArrayList<ProductsModel>();
			ProductsModel product = new ProductsModel();
			CartItemModel cartItemM = new CartItemModel();
			BeanUtils.copyProperties(cartItem, cartItemM);
			product.setCategoryId(cartItem.getCategoryId());
			product.setCategoryTypeId(cartItem.getCategoryTypeId());
			product.setProductId(cartItem.getProductId());
			product.setQuality(cartItem.getQuality());
			subCategories = subCategoriesDAO.getSubCategoriesById(cartItem.getProductId());
			subCategoriesImageDomain = subCategoriesImageDAO.getSubCategoriesImageById(cartItem.getProductId());
			cartItemM.setProductName(subCategories.getSubCategoriesName());
			cartItemM.setProductImage(subCategoriesImageDomain.getName());
			productsModel.add(product);
			cartItemM.setProductsModel(productsModel);
			cartItemModel.add(cartItemM);
		}
		return cartItemModel;
	}

	@Override
	public List<CartItemModel> getCartByCategoryType(String userId, long categoryTypeId) throws Exception {
		List<CartItemDomain> cartItemDomain = cartItemRepository.getCartItemsByUserAndCategoryTypeId(userId,  categoryTypeId);
		List<CartItemModel> cartItemModel = new ArrayList<CartItemModel>();
		SubCategoriesDomain subCategories = new SubCategoriesDomain();
		SubCategoriesImageDomain subCategoriesImageDomain = new SubCategoriesImageDomain();

		for (CartItemDomain cartItem : cartItemDomain) {
			List<ProductsModel> productsModel = new ArrayList<ProductsModel>();
			ProductsModel product = new ProductsModel();
			CartItemModel cartItemM = new CartItemModel();
			BeanUtils.copyProperties(cartItem, cartItemM);
			product.setCategoryId(cartItem.getCategoryId());
			product.setCategoryTypeId(cartItem.getCategoryTypeId());
			product.setProductId(cartItem.getProductId());
			product.setQuality(cartItem.getQuality());
			subCategories = subCategoriesDAO.getSubCategoriesById(cartItem.getProductId());
			subCategoriesImageDomain = subCategoriesImageDAO.getSubCategoriesImageById(cartItem.getProductId());
			cartItemM.setProductName(subCategories.getSubCategoriesName());
			cartItemM.setProductImage(subCategoriesImageDomain.getName());
			productsModel.add(product);
			cartItemM.setProductsModel(productsModel);
			cartItemModel.add(cartItemM);
		}
		return cartItemModel;
	}

	@Override
	public List<CartItemDomain> updateCart(CartItemModel cartItemModel) throws Exception {
		List<CartItemDomain> cartItemDomain = new ArrayList<CartItemDomain>();
		// List<ProductsModel> productsModel = cartItemModel.getProductsModel();
		cartItemDomain = cartUtils.updateCartInfo(cartItemModel);
		for (CartItemDomain cart : cartItemDomain) {
			cartItemRepository.save(cart);
		}
		return cartItemDomain;
	}

	public String deleteCartById(String cartItemId) throws Exception {
		cartItemRepository.deleteById(cartItemId);
		return "cart deleted";
	}

	public long cartCount(String userId) throws Exception {
		CartItemModel cartItemModel = new CartItemModel();
		cartItemModel.setCount(cartItemRepository.count());
		return cartItemModel.getCount(); 

	}
}
