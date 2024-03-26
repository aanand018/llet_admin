package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.StateDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class StateDAOImpl implements StateDAO {

	private static final Logger logger = LoggerFactory.getLogger(StateDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Override
	public String addState(StateDomain stateDomain) {
		try {
			entityManager.persist(stateDomain);
			return "State Data Saved";
		} catch (Exception e) {
			logger.error("Exception addState in StateDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<StateDomain> getStateList() throws Exception {
		try {
			String hql = "FROM StateDomain";
			return (List<StateDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getStateList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}

	@Override
	public StateDomain getStateListById(long stateId) throws Exception {
		try {
			String hql = "FROM StateDomain where stateId=?1";
			return (StateDomain) entityManager.createQuery(hql).setParameter(1, stateId).getSingleResult();

		} catch (Exception e) {
			logger.error("Exception in getStateListById" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<StateDomain> getStatedetails(long countryId) throws Exception {
		try {
			String hql = "FROM StateDomain where countryDomain.countryId=:coun";
			return (List<StateDomain>) entityManager.createQuery(hql).setParameter("coun", countryId).getResultList();
		} catch (Exception e) {
			logger.error("Exception in getStateList" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}

	@Override
	public String updateState(StateDomain stateDomain) throws Exception {
		try {
			StateDomain StateDomainbyId = getStateListById(stateDomain.getStateId());
			StateDomainbyId.setStateName(stateDomain.getStateName());
			StateDomainbyId.setCountryDomain(stateDomain.getCountryDomain());
			StateDomainbyId.setShortName(stateDomain.getShortName());
			entityManager.flush();
			return "State Data Updated successfully";
		} catch (Exception e) {
			logger.error("Exception in updateState" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	public String deleteStateById(long stateId) throws Exception {
		try {
			String hql = "Delete From StateDomain Where stateId=?1";
			entityManager.createQuery(hql).setParameter(1, stateId).executeUpdate();
			return "State Data Deleted successfully";
		} catch (Exception e) {
			logger.info("Exception in deleteStateById", e);
			throw new BACKEND_SERVER_ERROR();
		}
	}

}
