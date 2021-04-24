package com.cg.go.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;

public class OrderRepositoryImpl implements  IOrderRepository{
	public final EntityManagerFactory emf = com.cg.go.util.JpaUtil.getConnection();
	public final EntityManager entityManager = emf.createEntityManager();
	public final EntityTransaction transaction = entityManager.getTransaction();
	@Override
	public List<OrderEntity> findOrdersByUserId(String userId) {
		List<OrderEntity> list=new ArrayList<OrderEntity>();
		list=entityManager.createQuery("from OrderEntity where userId=:userId",OrderEntity.class).setParameter("userId", userId).getResultList();
		return list;
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		transaction.begin();
		List<OrderEntity> list=new ArrayList<OrderEntity>();
		list=entityManager.createQuery("from OrderEntity",OrderEntity.class).getResultList();
		transaction.commit();
		return list;
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException {
		transaction.begin();
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
				entityManager.persist(orderEntity);
				transaction.commit();
				return orderEntity;
		}
	}

	@Override
	public void deleteAllOrders() throws OrderException {
		transaction.begin();
		Query query=entityManager.createQuery("delete from OrderEntity");
		query.executeUpdate();
		transaction.commit();
	}

	@Override
	public void deleteOrderById(String orderId) throws OrderException {
		transaction.begin();
		OrderEntity orderEntity=entityManager.find(OrderEntity.class,orderId);	
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
				entityManager.remove(orderEntity);
			}
		transaction.commit();
	}

	@Override
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException {
		transaction.begin();
		OrderEntity orderEntity=entityManager.find(OrderEntity.class,orderId);	
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
			orderEntity.setDispatchDate(dispatchDate);
			orderEntity.setDeliveryDate(arrivalDate);
		}
		transaction.commit();
	}

}
