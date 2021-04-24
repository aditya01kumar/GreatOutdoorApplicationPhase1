package com.cg.go.service;

import java.util.List;
import com.cg.go.dao.ICartRepository;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

public class CartServiceImpl implements ICartService {
	private ICartRepository daoCartRepo;

	@Override
	public List<CartItemEntity> findCartlist(String userId) {
		return daoCartRepo.findCartlist(userId);
	}

	@Override
	public CartItemEntity findCartItem(String productId, String userId) {
		return daoCartRepo.findCartItem(productId, userId);
	}

	@Override
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException {

		if (cartItemEntity == null) {
			throw new CartException("cartItemEntity is not found");
		}
		CartItemEntity cartObject = daoCartRepo.addCart(cartItemEntity);
		return cartObject;
	}

	@Override
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException {

		if (cartItemEntity == null) {
			throw new CartException("cartItemEntity is not found");
		}
		CartItemEntity cartObject = daoCartRepo.updateCart(cartItemEntity);
		return cartObject;
	}

	@Override
	public void deleteCartItem(Long cartId, String productId) throws CartException {

		List<CartItemEntity> cartlist = daoCartRepo.findCartlist(productId);
		if (cartlist == null) {
			throw new CartException("productId not found");
		}
		daoCartRepo.deleteCartItem(cartId, productId);

	}

	@Override
	public void deleteCartlist(String userId) throws CartException {

		List<CartItemEntity> cartlist = daoCartRepo.findCartlist(userId);
		if (cartlist.isEmpty()) {
			throw new CartException("UserId not found");
		}
		daoCartRepo.deleteCartlist(userId);

	}

}
