package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.CartMapper;
import ninja.skyrocketing.pojo.Cart;
import ninja.skyrocketing.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cartMapper;
	@Override
	public List<Cart> getCartListByUserId(Integer userId) {
		return cartMapper.getCartListByUserId(userId);
	}
}
