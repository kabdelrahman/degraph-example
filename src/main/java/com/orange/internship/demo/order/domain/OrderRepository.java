package com.orange.internship.demo.order.domain;

import java.util.List;

public interface OrderRepository {
	public void saveOrUpdate(List<Order> orders);
}
