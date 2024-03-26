package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.SubCategoriesDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SubCategoriesDAOImpl implements SubCategoriesDAO {

	private static final Logger logger = LoggerFactory.getLogger(SubCategoriesDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public SubCategoriesDomain addSubCategories(SubCategoriesDomain subCategoriesDomain) throws Exception {
		try {
			SubCategoriesDomain subCategoriesDomain1 = new SubCategoriesDomain();
			entityManager.persist(subCategoriesDomain);
			subCategoriesDomain1.setSubCategoriesId(subCategoriesDomain.getSubCategoriesId());
			return subCategoriesDomain1;
		} catch (Exception e) {
			logger.error("Exception create in SubCategoriesDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<SubCategoriesDomain> getSubCategories() throws Exception {
		try {
			String hql = "FROM SubCategoriesDomain";
			return (List<SubCategoriesDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getSubCotegoriesList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public SubCategoriesDomain getSubCategoriesById(long subCategoriesId) throws Exception {
		try {
			String hql = "FROM SubCategoriesDomain where subCategoriesId=?1";
			return (SubCategoriesDomain) entityManager.createQuery(hql).setParameter(1, subCategoriesId)
					.getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in getSubCategorniesById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}

	@Override
	public String updateSubCategories(SubCategoriesDomain subCategoriesDomain) throws Exception {
		try {
			SubCategoriesDomain subCategoriesDomainbyId = getSubCategoriesById(
					subCategoriesDomain.getSubCategoriesId());
			subCategoriesDomainbyId.setSubCategoriesName(subCategoriesDomain.getSubCategoriesName());
			subCategoriesDomainbyId.setCategoriesDomain(subCategoriesDomain.getCategoriesDomain());
			subCategoriesDomainbyId.setCategoriesTypeDomain(subCategoriesDomain.getCategoriesTypeDomain());
			subCategoriesDomainbyId.setPrice(subCategoriesDomain.getPrice());
			subCategoriesDomainbyId.setQuantity(subCategoriesDomain.getQuantity());
			subCategoriesDomainbyId.setDescription(subCategoriesDomain.getDescription());
			subCategoriesDomainbyId.setServe(subCategoriesDomain.getServe());
			entityManager.flush();
			return "Sub Categories Data Updated successfully";
		} catch (Exception e) {
			logger.error("Exception in updateSubCategories" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String deleteSubCategories(long subCategoriesId) throws Exception {
		try {
			String hql = "Delete From SubCategoriesDomain Where subCategoriesId=?1";
			entityManager.createQuery(hql).setParameter(1, subCategoriesId).executeUpdate();
			return "Sub Categories Data deleted successfully";
		} catch (Exception e) {
			logger.info("Exception in deleteSubCategories", e);
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<SubCategoriesDomain> getSubCategoriesByCatId(long categoriesId) throws Exception {
		try {
			String hql = "FROM SubCategoriesDomain where categoriesDomain.categoriesId=:catId";
			return (List<SubCategoriesDomain>) entityManager.createQuery(hql).setParameter("catId", categoriesId)
					.getResultList();
		} catch (Exception e) {
			logger.error("Exception in getSubCategoriesByCatId" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}
	
	@Override
	public List<SubCategoriesDomain> getSubCategoriesByCatTypeId(long categoriesTypeId) throws Exception {
		try {
			String hql = "FROM SubCategoriesDomain where categoriesTypeDomain.categoriesTypeId=:catTypeId";
			return (List<SubCategoriesDomain>) entityManager.createQuery(hql).setParameter("catTypeId", categoriesTypeId)
					.getResultList();
		} catch (Exception e) {
			logger.error("Exception in getSubCategoriesByCatTypeId" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

}
