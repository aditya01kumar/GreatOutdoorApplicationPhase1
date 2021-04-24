package com.cg.go.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.go.entity.SalesReportEntity;

public class SalesReportRepositoryImpl implements ISalesReportRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public void updateProductReport(String productId, Integer quantity, double totalSale) {
		SalesReportEntity salesReportEntity = entityManager.createQuery("select s from SalesReportEntity s where s.productId:productId",SalesReportEntity.class).setParameter("productId", productId).getSingleResult();
		if (salesReportEntity == null) {
			entityManager.persist(new SalesReportEntity());
		}
		salesReportEntity.setQuantitySold(quantity);
		salesReportEntity.setTotalSale(totalSale);
		entityManager.merge(salesReportEntity);
		transaction.commit();
	}

	@Override
	public boolean existsByProductId(String productId) {
		transaction.begin();
		SalesReportEntity salesReportEntity = entityManager.find(SalesReportEntity.class, productId);
		transaction.commit();
		if (salesReportEntity == null)
			return false;
		return true;
	}

	@Override
	public SalesReportEntity findByProductId(String productId) {
		transaction.begin();
		SalesReportEntity salesReportEntity = entityManager.find(SalesReportEntity.class, productId);
		transaction.commit();
		return salesReportEntity;
	}

}
