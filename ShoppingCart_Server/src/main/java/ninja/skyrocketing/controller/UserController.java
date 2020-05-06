package ninja.skyrocketing.controller;

import ninja.skyrocketing.common.RespBean;
import ninja.skyrocketing.pojo.User;
import ninja.skyrocketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//RestController返回的数据都是json格式
@RestController
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public User login(@RequestBody User user){
		return userService.login(user);
	}
}
