package com.cg.go.service;

import java.util.List;

import com.cg.go.dao.IWishlistRepository;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;

public class WishlistServiceImpl implements IWishlistService {
	private IWishlistRepository daoWishlist;

	@Override
	public List<WishlistItemEntity> findAllItems() {
		return daoWishlist.findAllItems();
	}

	@Override
	public List<WishlistItemEntity> findWishlist(String userId) {
		return daoWishlist.findWishlist(userId);
	}

	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		return daoWishlist.findWishlistItem(productId, userId);
	}

	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
		daoWishlist.addProductToWishlist(prodId, wishlistID);

	}

	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		if (productId == null || userId == null) {
			throw new WishlistException("productid is null or userId is null");
		}
		daoWishlist.deleteWishlistItem(productId, userId);

	}

	@Override
	public void deleteWishlist(String userId) throws WishlistException {
		if (userId == null) {
			throw new WishlistException(" userId is null");
		}
		daoWishlist.deleteWishlist(userId);

	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
		if (wishlistItem == null) {
			throw new WishlistException(" wishlistItem is null");
		}
		return daoWishlist.addWishlistItem(wishlistItem);
	}

}
