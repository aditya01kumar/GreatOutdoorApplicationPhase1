package com.cg.go.service;

import java.util.List;

import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

public class ProductServiceImpl implements IProductService {
	public IProductService daoProductService;

	@Override
	public List<ProductEntity> findAllProducts() {
		return daoProductService.findAllProducts();
	}

	@Override
	public ProductEntity findByProductId(String id) {
		return daoProductService.findByProductId(id);
	}

	@Override
	public List<ProductEntity> findByProductCategory(String productCategory) {

		return daoProductService.findByProductCategory(productCategory);
	}

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException {
		
		return daoProductService.addProduct(productEntity);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException {
		
		return daoProductService.updateProduct(productEntity);
	}

	@Override
	public void updateProductQuantity(Integer quantity, String productId) {
		daoProductService.updateProductQuantity(quantity, productId);
	}

	@Override
	public void deleteByProductId(String id) throws ProductException {
		daoProductService.deleteByProductId(id);

	}

	@Override
	public List<ProductEntity> search(String keyword) {
		return daoProductService.search(keyword);
	}

	@Override
	public List<ProductEntity> filter(double maxPrice) {
		return daoProductService.filter(maxPrice);
	}

}
