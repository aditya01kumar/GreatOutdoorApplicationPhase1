package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

public class ProductRepositoryImpl implements IProductRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public List<ProductEntity> findAllProducts() {
		transaction.begin();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		list = entityManager.createQuery("select a from ProductEntity a", ProductEntity.class).getResultList();
		transaction.commit();
		return list;
	}

	@Override
	public ProductEntity findByProductId(String id) {
		transaction.begin();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
		transaction.commit();
		return productEntity;
	}

	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {
		transaction.begin();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		list = entityManager
				.createQuery("select a from ProductEntity a where category=:'productCategory'", ProductEntity.class)
				.setParameter("productCategory", productCategory).getResultList();
		transaction.commit();
		return list;
	}

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException {
		transaction.begin();
		if (productEntity == null) {
			throw new ProductException("productEntity is not found");
		}
		entityManager.merge(productEntity);
		transaction.commit();
		return productEntity;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException {
		transaction.begin();
		if (productEntity == null) {
			throw new ProductException("productEntity is not found");
		}
		entityManager.merge(productEntity);
		transaction.commit();
		return productEntity;
	}

	@Override
	public void updateProductQuantity(Integer quantity, String productId) {
		transaction.begin();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, productId);
		productEntity.setQuantity(quantity);
		transaction.commit();

	}

	@Override
	public void deleteByProductId(String id) throws ProductException {
		transaction.begin();
		ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
		if (productEntity == null) {
			throw new ProductException("productEntity not found so cannot be deleted");
		}
		entityManager.remove(productEntity);
		transaction.commit();
	}

	@Override
	public List<ProductEntity> search(String keyword) {
		transaction.begin();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		list = entityManager
				.createQuery("select a from ProductEntity a where productName='productName'", ProductEntity.class)
				.setParameter("productName", keyword).getResultList();
		transaction.commit();
		return list;
	}

	@Override
	public List<ProductEntity> filter(double maxPrice) {
		transaction.begin();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		list = entityManager.createQuery("select a from ProductEntity a where price<='maxPrice'", ProductEntity.class)
				.setParameter("maxPrice", maxPrice).getResultList();
		transaction.commit();
		return list;
	}

}
