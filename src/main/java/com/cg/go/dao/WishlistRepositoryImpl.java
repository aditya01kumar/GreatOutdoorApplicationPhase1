package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;

public class WishlistRepositoryImpl implements IWishlistRepository {
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();
	@Override
	public List<WishlistItemEntity> findAllItems() {
		 List<WishlistItemEntity>  list  =  new  ArrayList<WishlistItemEntity>();
		 transaction.begin();
		 list  =  entityManager.createQuery("select  a  from  WishlistItemEntity  a",  WishlistItemEntity.class).getResultList();
		 transaction.commit();
		 return list;
	}

	@Override
	public List<WishlistItemEntity> findWishlist(String userId) {
		List<WishlistItemEntity>  wishlistEntity= entityManager.createQuery("select  a  from  WishlistItemEntity  a where a.userId:userId",  WishlistItemEntity.class).setParameter("userId", userId).getResultList();
		 return  wishlistEntity;
	}

	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		TypedQuery<WishlistItemEntity> query = entityManager.createQuery("select c from WishlistItemEntity where c.userId=:userId and c.productId:productId", WishlistItemEntity.class);
        query.setParameter("userId", userId);
        query.setParameter("productId", productId);
        WishlistItemEntity list=query.getSingleResult();
		return list;
	}

	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
	
		
	}

	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		
		
	}

	@Override
	public void deleteWishlist(String userId) throws WishlistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
		// TODO Auto-generated method stub
		return null;
	}

}
