package com.snipe.let.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.CountryDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CountryDAOImpl implements CountryDAO {

	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addCountry(CountryDomain coutryDomain) {
		try {
			entityManager.persist(coutryDomain);
			return "Country Data Saved";
		} catch (Exception e) {
			logger.error("Exception create in CountryDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public List<CountryDomain> getCountryList() throws Exception {
		try {
			String hql = "FROM CountryDomain";
			return (List<CountryDomain>) entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			logger.error("Exception getCountryList in CountryDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public CountryDomain getCountryListById(long countryId) throws Exception {
		try {
			String hql = "FROM CountryDomain where countryId=?1";
			return (CountryDomain) entityManager.createQuery(hql).setParameter(1, countryId).getSingleResult();
		} catch (Exception e) {
			logger.error("Exception getCountryListById in CountryDAOImpl " + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	@Override
	public String updateCountry(CountryDomain countryDomain) throws Exception {
		try {
			CountryDomain countryDomain1 = getCountryListById(countryDomain.getCountryId());
			countryDomain1.setCountryName(countryDomain.getCountryName());
			countryDomain1.setCountryCode(countryDomain.getCountryCode());
			countryDomain1.setShortname(countryDomain.getShortname());
			entityManager.flush();
			return "Country Data Updated successfully";
		} catch (Exception e) {
			logger.error("Exception updateCountry in CountryDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}
	}

	public String deleteCountryById(long countryId) throws Exception {
		try {
			String hql = "Delete From CountryDomain Where countryId=?1";
			entityManager.createQuery(hql).setParameter(1, countryId).executeUpdate();
			return "Country Data Deleted successfully";
		} catch (Exception e) {
			logger.info("Exception deleteCountryById in CountryDAOImpl", e);
			throw new BACKEND_SERVER_ERROR();

		}
	}
}
