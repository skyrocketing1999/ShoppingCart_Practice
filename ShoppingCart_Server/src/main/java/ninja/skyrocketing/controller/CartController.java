package ninja.skyrocketing.controller;

import ninja.skyrocketing.pojo.Cart;
import ninja.skyrocketing.service.CartService;
import ninja.skyrocketing.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping("/list")
	public List<Cart> getCartList(@RequestParam("userId") Integer userId){
		return cartService.getCartListByUserId(userId);
	}
}
