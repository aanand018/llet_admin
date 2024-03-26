package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.CategoriesTypeDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CategoriesTypeDAOImpl implements CategoriesTypeDAO {

	private static final Logger logger = LoggerFactory.getLogger(CategoriesTypeDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addCategoriesType(CategoriesTypeDomain categoriesTypeDomain) throws Exception {
		try {
			entityManager.persist(categoriesTypeDomain);
			return "Categories Type Data Saved";
		} catch (Exception e) {
			logger.error("Exception create in CategoriesTypeDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CategoriesTypeDomain> getCategoriesType() throws Exception {
		try {
			String hql = "FROM CategoriesTypeDomain";
			return (List<CategoriesTypeDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getCotegoriesTypeList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public CategoriesTypeDomain getCategoriesTypeById(long categoriesTypeId) throws Exception {
		try {
			String hql = "FROM CategoriesTypeDomain where categoriesTypeId=?1";
			return (CategoriesTypeDomain) entityManager.createQuery(hql).setParameter(1, categoriesTypeId)
					.getSingleResult();

		} catch (Exception e) {
			logger.error("Exception in getCategorniesTypeById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String updateCategoriesType(CategoriesTypeDomain categoriesTypeDomain) throws Exception {
		try {

			CategoriesTypeDomain categoriesTypeDomain1 = getCategoriesTypeById(categoriesTypeDomain.getCategoriesTypeId());
			categoriesTypeDomain1.setCategoriesTypeName(categoriesTypeDomain.getCategoriesTypeName());
			entityManager.flush();
			return "CategorieTypes  Data Updated Successfully";
		} catch (Exception e) {
			logger.error("Exception in updateCategoriesType" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String deleteCategoriesType(long categoriesTypeId) throws Exception {
		try {
			String hql = "Delete From CategoriesTypeDomain Where categoriesTypeId=?1";
			entityManager.createQuery(hql).setParameter(1, categoriesTypeId).executeUpdate();
			return "Categories Type Data deleted Successfully";
		} catch (Exception e) {
			logger.info("Exception in deleteCategoriesType", e);
			throw new BACKEND_SERVER_ERROR();

		}
	}

}
