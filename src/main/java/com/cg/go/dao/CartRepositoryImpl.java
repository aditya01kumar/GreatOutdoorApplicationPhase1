package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

public class CartRepositoryImpl implements ICartRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();

	@Override
	public List<CartItemEntity> findCartlist(String userId) {
		List<CartItemEntity> list=new ArrayList<CartItemEntity>();
		list=entityManager.createQuery("select c from CartItemEntity where c.userId:userId ",CartItemEntity.class).setParameter("userId",userId).getResultList();
		return list;
	}

	@Override
	public CartItemEntity findCartItem(String productId, String userId) {
		CartItemEntity entity =entityManager.find(CartItemEntity.class, productId);
		entity.setUserId(userId);
		return entity;
	}

	@Override
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException {
		if(cartItemEntity==null) {
			throw new CartException("Could not add again because already added to cart");
		}
		transaction.begin();
        entityManager.persist(cartItemEntity);
        transaction.commit();
		return cartItemEntity;
	}

	@Override
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException {
		transaction.begin();
		entityManager.merge(cartItemEntity);
		transaction.commit();
		return cartItemEntity;
	}

	@Override
	public void deleteCartItem(Long cartId, String productId) throws CartException {
		TypedQuery<CartItemEntity> entity= entityManager.createQuery("select c from CartItemEntity where c.cartId:cartId and c.productId:productId",CartItemEntity.class);
		entity.setParameter("cartId", cartId);
		entity.setParameter("productId", productId);
		transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
		
	}

	@Override
	public void deleteCartlist(String userId) throws CartException {
		TypedQuery<CartItemEntity> entity= entityManager.createQuery("select c from CartItemEntity where c.userId:userId",CartItemEntity.class).setParameter("userId", userId);
		if(userId==null) {
			throw new CartException("Not found in the cart");
		}
		transaction.begin();
        entityManager.remove(entity);
        transaction.commit();
		
	}

}