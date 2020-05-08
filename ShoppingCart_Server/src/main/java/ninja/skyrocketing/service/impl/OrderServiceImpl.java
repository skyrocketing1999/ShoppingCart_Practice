package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.OrderMapper;
import ninja.skyrocketing.pojo.Order;
import ninja.skyrocketing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> getOrderList(Integer userId) {
		return orderMapper.getOrderList(userId);
	}
	
	@Override
	public List<Order> getOrderUnionList(Integer orderId) {
		return orderMapper.getOrderUnionList(orderId);
	}
}
