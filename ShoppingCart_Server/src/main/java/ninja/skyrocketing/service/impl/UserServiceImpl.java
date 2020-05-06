package ninja.skyrocketing.service.impl;

import ninja.skyrocketing.mapper.UserMapper;
import ninja.skyrocketing.pojo.User;
import ninja.skyrocketing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		return userMapper.selectByUser(user);
	}
}
