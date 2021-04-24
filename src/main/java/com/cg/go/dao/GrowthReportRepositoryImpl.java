package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.SalesReportException;

public class GrowthReportRepositoryImpl implements IGrowthReportRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();
	private GrowthReportEntity growthReportEntity;

	@Override
	public List<GrowthReportEntity> findAllGrowthReport() {
		transaction.begin();
		String jpql = "select e from GrowthReportEntity e";
		List<GrowthReportEntity> list = new ArrayList<GrowthReportEntity>();
		list = entityManager.createQuery(jpql, GrowthReportEntity.class).getResultList();
		transaction.commit();
		return list;
	}

	@Override
	public void addGrowthReport() throws SalesReportException {
		transaction.begin();
		if (growthReportEntity == null) {
			throw new SalesReportException("growthReportEntity not found");
		}
		String jpql = "select e from GrowthReportEntity e";
		Query query = entityManager.createQuery(jpql, GrowthReportEntity.class);
		transaction.commit();
		query.executeUpdate();

	}

	@Override
	public void deleteAllGrowthReport() throws GrowthReportException {
		transaction.begin();
		Query query = entityManager.createQuery("delete from GrowthReportEntity");
		query.executeUpdate();
		transaction.commit();

	}

	@Override
	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException {
		transaction.begin();
		GrowthReportEntity growthReportEntity = entityManager.find(GrowthReportEntity.class, growthReportId);
		if (growthReportEntity==null) {
			throw new GrowthReportException("growthReportEntity not found");
		} else {
			entityManager.remove(growthReportEntity);
		}
		transaction.commit();
	}

}
