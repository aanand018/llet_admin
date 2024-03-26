package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.CategoriesDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CategoriesDAOImpl implements CategoriesDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoriesDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addCategories(CategoriesDomain categoriesDomain) {
		try {
			entityManager.persist(categoriesDomain);
			return "Categories Data Saved";
		} catch (Exception e) {
			logger.error("Exception addCategories in CategoriesDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CategoriesDomain> getCategories() throws Exception {
		try {
			String hql = "FROM CategoriesDomain";
			return (List<CategoriesDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getCategoriesList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public CategoriesDomain getCategoriesById(long categoriesId) throws Exception {
		try {
			String hql = "FROM CategoriesDomain where categoriesId=?1";
			return (CategoriesDomain) entityManager.createQuery(hql).setParameter(1, categoriesId).getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in getCategoriesById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String updateCategories(CategoriesDomain categoriesDomain) throws Exception {
		try {
			CategoriesDomain categoriesDomainbyId = getCategoriesById(categoriesDomain.getCategoriesId());
			categoriesDomainbyId.setCategoriesName(categoriesDomain.getCategoriesName());
			categoriesDomainbyId.setCategoriesTypeDomain(categoriesDomain.getCategoriesTypeDomain());
			entityManager.flush();
			return "Categories Data Updated successfully";
		} catch (Exception e) {
			logger.error("Exception in updateCategories" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	public String deleteCategories(long categoriesId) throws Exception {
		try {
			String hql = "Delete From CategoriesDomain Where categoriesId=?1";
			entityManager.createQuery(hql).setParameter(1, categoriesId).executeUpdate();
			return "Categories Data deleted successfully";
		} catch (Exception e) {
			logger.info("Exception in deleteCategories", e);
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CategoriesDomain> getCategoriesByTypeId(long categoriesTypeId) throws Exception {
		try {
			String hql = "FROM CategoriesDomain where categoriesTypeDomain.categoriesTypeId=:typeId";
			return (List<CategoriesDomain>) entityManager.createQuery(hql).setParameter("typeId", categoriesTypeId).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getCategoriesByTypeId" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}
}
