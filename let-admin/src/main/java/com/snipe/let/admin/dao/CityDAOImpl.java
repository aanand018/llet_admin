package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CityDAOImpl implements CityDAO {

	private static final Logger logger = LoggerFactory.getLogger(CityDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Override
	public String addCity(CityDomain cityDomain) {
		try {
			entityManager.persist(cityDomain);
			return "city Data Saved";
		} catch (Exception e) {
			logger.error("Exception create in CityDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CityDomain> getCityList() throws Exception {
		try {
			String hql = "FROM CityDomain";
			return (List<CityDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getCityList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public CityDomain getCityListById(long cityId) throws Exception {
		try {
			String hql = "FROM CityDomain where cityId=?1";
			return (CityDomain) entityManager.createQuery(hql).setParameter(1, cityId).getSingleResult();
		} catch (Exception e) {
			logger.error("Exception in getCityListById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String updateCity(CityDomain cityDomain) throws Exception {
		try {
			CityDomain cityDomainById = getCityListById(cityDomain.getCityId());
			cityDomainById.setCityName(cityDomain.getCityName());
			cityDomainById.setStateDomain(cityDomain.getStateDomain());
			cityDomainById.setShortName(cityDomain.getShortName());
			entityManager.flush();
			return "City Data Updated successfully";
		} catch (Exception e) {
			logger.error("Exception in updateCity" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	public String deleteCityById(long cityId) throws Exception {
		try {
			String hql = "Delete From CityDomain Where cityId=?1";
			entityManager.createQuery(hql).setParameter(1, cityId).executeUpdate();
			return "City Data Deleted successfully";
		} catch (Exception e) {
			logger.info("Exception in deleteCityById", e);
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CityDomain> getCityList(long stateId) throws Exception {
		try {
			String hql = "FROM CityDomain where stateDomain.stateId=:stat";
			return (List<CityDomain>) entityManager.createQuery(hql).setParameter("stat", stateId).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getCityList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}
}
