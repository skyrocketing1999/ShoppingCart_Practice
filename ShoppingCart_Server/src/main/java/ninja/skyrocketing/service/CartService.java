package ninja.skyrocketing.service;

import ninja.skyrocketing.pojo.Cart;

import java.util.List;

public interface CartService {
	//根据用户id查询购物车列表
	List<Cart> getCartListByUserId(Integer userId);
}
