package ninja.skyrocketing.controller;

import ninja.skyrocketing.pojo.Order;
import ninja.skyrocketing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private List<Order> getOrderList(@RequestParam("userId") Integer userId){
		return orderService.getOrderList(userId);
	}
	
	@RequestMapping(value = "/unionList", method = RequestMethod.GET)
	private List<Order> getUnionOrderList(@RequestParam("orderId") Integer orderId){
		return orderService.getOrderUnionList(orderId);
	}
}
