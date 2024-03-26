package com.snipe.let.admin.dao;
//package com.snipe.let.admin.dao;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.TimeZone;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.snipe.let.admin.domain.CartItemDomain;
//import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
//import com.snipe.let.admin.exception.LetRestException.SAVE_FAILED;
//import com.snipe.let.admin.model.CartItemModel;
//import com.snipe.let.admin.utils.DateUtility;
//
//@Repository
//@Transactional
//@SuppressWarnings("unchecked")
//public class CartItemDAOImpl implements CartItemDAO {
//
//	private static final Logger logger = LoggerFactory.getLogger(CartItemDAOImpl.class);
//
//	@Autowired
//	EntityManager entityManager;
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public CartItemDomain saveCartItem(CartItemDomain cartItemDomain) throws Exception {
//		try {
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtility.DATE_FORMAT_YYYY_MM_DD_HHMMSS);
//			simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
//			String sql = "INSERT INTO let_admin.cart(cart_item_id, category_id, category_type_id, quality, product_id, user_id, quantity, created_date, modified_date, status, count) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//			int res = jdbcTemplate.update(sql,
//					new Object[] { cartItemDomain.getCartItemId(), cartItemDomain.getCategoryId(),
//							cartItemDomain.getCategoryTypeId(), cartItemDomain.getQuality(),
//							cartItemDomain.getProductId(), cartItemDomain.getUserId(), cartItemDomain.getQuantity(),
//							simpleDateFormat.format(new Date()), simpleDateFormat.format(new Date()),
//							cartItemDomain.isStatus(),cartItemDomain.getCount()});
//			if (res == 1) {
//				return cartItemDomain;
//			} else
//				throw new SAVE_FAILED("Cart Item save failed");
//		} catch (Exception e) {
//			logger.error("Exception saveCartItem in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public List<CartItemDomain> getCartItems(String userId) throws Exception {
//		try {
//			String hql = "FROM CartItemDomain where userId=?1";
//			return (List<CartItemDomain>) entityManager.createQuery(hql).setParameter(1, userId).getResultList();
//		} catch (NoResultException e) {
//			logger.error("NoResultException getCartItems in CartItemDAOImpl" + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error("Exception getCartItems in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//	
//	@Override
//	public CartItemDomain getCartItemsByPrdtId(long productId,String userId) throws Exception {
//		try {
//			String hql = "FROM CartItemDomain where productId=?1 and userId=?2";
//			return (CartItemDomain) entityManager.createQuery(hql).setParameter(1, productId).setParameter(2, userId).getSingleResult();
//		} catch (NoResultException e) {
//			logger.error("NoResultException getCartItemsByPrdtId in CartItemDAOImpl" + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error("Exception getCartItemsByPrdtId in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//	@Override
//	public CartItemDomain getCartItemsById(String cartItemId) throws Exception {
//		try {
//			String hql = "FROM CartItemDomain where cartItemId=?1";
//			return (CartItemDomain) entityManager.createQuery(hql).setParameter(1, cartItemId).getSingleResult();
//		} catch (NoResultException e) {
//			logger.error("NoResultException getCartItemsById in CartItemDAOImpl" + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error("Exception getCartItemsById in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public List<CartItemDomain> getCartItem(String userId, long categoryId) throws Exception {
//		try {
//			String hql = "FROM CartItemDomain where userId=?1 and categoryId=?2";
//			return (List<CartItemDomain>) entityManager.createQuery(hql).setParameter(1, userId)
//					.setParameter(2, categoryId).getResultList();
//		} catch (NoResultException e) {
//			logger.error("NoResultException getCartItem in CartItemDAOImpl" + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error("Exception getCartItem in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public List<CartItemDomain> getCartByCategoryType(String userId, long categoryTypeId) throws Exception {
//		try {
//			String hql = "FROM CartItemDomain where userId=?1 and categoryTypeId=?2";
//			return (List<CartItemDomain>) entityManager.createQuery(hql).setParameter(1, userId)
//					.setParameter(2, categoryTypeId).getResultList();
//		} catch (NoResultException e) {
//			logger.error("NoResultException getCartByCategoryType in CartItemDAOImpl" + e.getMessage());
//			return null;
//		} catch (Exception e) {
//			logger.error("Exception getCartByCategoryType in CartItemDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//	
//	@Override
//	public String updatecart(CartItemDomain cartItemDomain) throws Exception {
//		try {
//			CartItemDomain cartItemDomainById = getCartItemsById(cartItemDomain.getCartItemId());
//			cartItemDomainById.setCount(cartItemDomain.getCount());
//			entityManager.flush();
//			return "cart Data Updated successfully";
//		} catch (Exception e) {
//			logger.error("Exception in updatecart" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//	
//	public String deleteCartById(String cartItemId) throws Exception {
//		try {
//			String hql = "Delete From CartItemDomain Where cartItemId=?1";
//			entityManager.createQuery(hql).setParameter(1, cartItemId).executeUpdate();
//			return "cart Data Deleted successfully";
//		} catch (Exception e) {
//			logger.info("Exception in deleteCartById", e);
//			throw new BACKEND_SERVER_ERROR();
//		}
//
//	}
//	
//	@Override
//	public CartItemModel cartCount(String userId) throws Exception {
//
//		try {
//			String sql = "select count(*) as total from let_admin.cart where user_id=?";
//			return jdbcTemplate.queryForObject(sql, new Object[] {userId},
//					new BeanPropertyRowMapper<CartItemModel>(CartItemModel.class));
//		} catch (Exception e) {
//			logger.error("Exception in cartCount", e);
//			throw new BACKEND_SERVER_ERROR();
//		}
//
//	}
//}
