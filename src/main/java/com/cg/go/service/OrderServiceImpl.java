package com.cg.go.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.go.dao.IOrderRepository;
import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;

public class OrderServiceImpl implements IOrderService {
	private IOrderRepository daoOrder;

	@Override
	public List<OrderEntity> findOrdersByUserId(String userId) {
		return daoOrder.findOrdersByUserId(userId);
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		return daoOrder.findAllOrders();
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException {
		try {
			List<OrderEntity> orderlist = daoOrder.findAllOrders();
			if (orderlist.isEmpty()) {
				throw new OrderException("UserId not found");
			}
			OrderEntity order = daoOrder.addOrder(orderEntity);
			return order;
		} catch (OrderException orderException) {
			System.out.println(orderException.getMessage());
		}
		return new OrderEntity();
	}

	@Override
	public void deleteAllOrders() throws OrderException {
		try {
			List<OrderEntity> orderlist = daoOrder.findAllOrders();
			if (orderlist.isEmpty()) {
				throw new OrderException("No Order in the list to delete");
			}
			daoOrder.deleteAllOrders();
		} catch (OrderException orderException) {
			System.out.println(orderException.getMessage());
		}
	}

	@Override
	public void deleteOrderById(String orderId) throws OrderException {
		daoOrder.deleteOrderById(orderId);
	}

	@Override
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException {
		daoOrder.updateDate(orderId, dispatchDate, arrivalDate);
	}

}
