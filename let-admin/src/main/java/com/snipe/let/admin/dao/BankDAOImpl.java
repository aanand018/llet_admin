package com.snipe.let.admin.dao;
//package com.snipe.let.admin.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.snipe.let.admin.domain.BankDomain;
//import com.snipe.let.admin.exception.LetRestException.BACKEND_SERVER_ERROR;
//
//@Repository
//@Transactional
//@SuppressWarnings("unchecked")
//public class BankDAOImpl implements BankDAO {
//
//	private static final Logger logger = LoggerFactory.getLogger(BankDAOImpl.class);
//
//	@Autowired
//	EntityManager entityManager;
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	@Override
//	public String addBank(BankDomain bankDomain) {
//		try {
//			entityManager.persist(bankDomain);
//			return "Bank Data Saved";
//		} catch (Exception e) {
//			logger.error("Exception addBank in BankDAOImpl" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public List<BankDomain> getBankList() throws Exception {
//		try {
//			String hql = "FROM BankDomain";
//			return (List<BankDomain>) entityManager.createQuery(hql).getResultList();
//		} catch (Exception e) {
//			logger.error("Exception in getBankList" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public BankDomain getBankListById(long bankId) throws Exception {
//		try {
//			String hql = "FROM BankDomain where bankId=?1";
//			return (BankDomain) entityManager.createQuery(hql).setParameter(1, bankId).getSingleResult();
//		} catch (Exception e) {
//			logger.error("Exception in getBankListById" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	@Override
//	public String updateBank(BankDomain bankDomain) throws Exception {
//		try {
//			BankDomain bankDomainbyId = getBankListById(bankDomain.getBankId());
//			bankDomainbyId.setBankName(bankDomain.getBankName());
//			entityManager.flush();
//			return "Bank Data Updated successfully";
//		} catch (Exception e) {
//			logger.error("Exception in updateBank" + e.getMessage());
//			throw new BACKEND_SERVER_ERROR();
//		}
//	}
//
//	public String deleteBankById(long bankId) throws Exception {
//		try {
//			String hql = "Delete From BankDomain Where bankId=?1";
//			entityManager.createQuery(hql).setParameter(1, bankId).executeUpdate();
//			return "Bank Data Deleted successfully";
//		} catch (Exception e) {
//			logger.info("Exception in deleteBankById", e);
//			throw new BACKEND_SERVER_ERROR();
//		}
//
//	}
//
//	@Override
//	public BankDomain bankCount() throws Exception {
//
//		try {
//			String sql = "select count(*) as total from let_admin.bank";
//			return jdbcTemplate.queryForObject(sql, new Object[] {},
//					new BeanPropertyRowMapper<BankDomain>(BankDomain.class));
//
//		} catch (Exception e) {
//			logger.error("Exception in bankCount", e);
//			throw new BACKEND_SERVER_ERROR();
//		}
//
//	}
//
//}
