package com.snipe.let.admin.dao;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snipe.let.admin.domain.CatalogueDomain;
import com.snipe.let.admin.domain.CityDomain;
import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
import com.snipe.let.admin.exception.LetRestException.Catalogue_NOT_FOUND;



@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CatalogueDAOImpl implements CatalogueDAO{

	private static final Logger logger = LoggerFactory.getLogger(CatalogueDAOImpl.class);

	@Autowired
	EntityManager entityManager;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CatalogueDomain> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate,LocalDateTime toDate, String storeType,String catalogueType) throws Exception {

		try {

			String sql="SELECT * FROM let_admin.catalogue where state_id= ? and city_id= ? and from_date>=? and ?<=to_date and store_type=? and catalogue_type=?";	

			return (List<CatalogueDomain>) jdbcTemplate.query(sql, new Object[] { stateId , cityId,fromDate,fromDate,storeType,catalogueType},
					new BeanPropertyRowMapper<CatalogueDomain>(CatalogueDomain.class));
		} catch (NoResultException e) {
			logger.error("NoResultException catelogueInfoWhorRetlr in CatalogueDAOImpl" + e.getMessage());
			throw new Catalogue_NOT_FOUND(stateId, cityId, fromDate, toDate, storeType,catalogueType);
		} catch (Exception e) {
			logger.error("Exception catelogueInfoWhorRetlr in CatalogueDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}


	@Override
	public List<CatalogueDomain> catelogueInfonWHorRL(long stateId, long cityId, LocalDateTime fromDate,LocalDateTime toDate) throws Exception {

		try {

			String sql="SELECT * FROM let_admin.catalogue where state_id= ? and city_id= ? and from_date>=? and ?<=to_date";	

			return (List<CatalogueDomain>) jdbcTemplate.query(sql, new Object[] { stateId , cityId,fromDate,fromDate,},
					new BeanPropertyRowMapper<CatalogueDomain>(CatalogueDomain.class));
		} catch (NoResultException e) {
			logger.error("NoResultException catelogueInfoWhorRetlr in CatalogueDAOImpl" + e.getMessage());
			throw new Catalogue_NOT_FOUND(stateId, cityId, fromDate, toDate);
		} catch (Exception e) {
			logger.error("Exception catelogueInfoWhorRetlr in CatalogueDAOImpl" + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}


	@Override
	public void addCatalogueDomain(CatalogueDomain catDomain) {
		try {
			//entityManager.persist(catDomain);
			System.out.println(catDomain);
		}catch (Exception e) {
			logger.error("Exception   " + e.getMessage());
			throw new BACKEND_SERVER_ERROR();
		}

	}

}
