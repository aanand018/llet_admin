package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.SubCategoriesImageDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class SubCategoriesImageDAOImpl implements SubCategoriesImageDAO {

	private static final Logger logger = LoggerFactory.getLogger(SubCategoriesDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addSubCategoriesImage(SubCategoriesImageDomain subCategoriesImageDomain) throws Exception {
		try {
			entityManager.persist(subCategoriesImageDomain);
			return "Sub Categories Image Saved";
		} catch (Exception e) {
			logger.error("Exception create in SubCategoriesImageDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public SubCategoriesImageDomain getSubCategoriesImageById(long subCategoriesId) throws Exception {
		try {
			String hql = "FROM SubCategoriesImageDomain where subCategoriesId=:SCId";
			return (SubCategoriesImageDomain) entityManager.createQuery(hql).setParameter("SCId", subCategoriesId)
					.getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in getSubCategoriesImageById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}

	@Override
	public List<SubCategoriesImageDomain> getSubCategoriesImagesbysubCategoriesId(long subCategoriesId)
			throws Exception {
		try {
			String hql = "FROM SubCategoriesImageDomain where subCategoriesDomain.subCategoriesId=:SCId";
			return (List<SubCategoriesImageDomain>) entityManager.createQuery(hql).setParameter("SCId", subCategoriesId)
					.getResultList();
		} catch (Exception e) {
			logger.error("Exception in getSubCategoriesImagesbysubCategoriesId" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<SubCategoriesImageDomain> getSubCategoriesImageList() throws Exception {
		try {
			String hql = "FROM SubCategoriesImageDomain";
			return (List<SubCategoriesImageDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getSubCategoriesImageList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

}
