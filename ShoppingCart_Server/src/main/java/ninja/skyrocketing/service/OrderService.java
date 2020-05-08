package ninja.skyrocketing.service;

import ninja.skyrocketing.pojo.Order;

import java.util.List;

public interface OrderService {
	List<Order> getOrderList(Integer userId);
	
	List<Order> getOrderUnionList(Integer orderId);
}
