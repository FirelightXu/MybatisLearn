package config.mapper;

import java.util.List;

import pojo.QueryVo;
import pojo.User;
import pojo.OrderUser;

public interface UserMapper {
	User find(Integer id);
	void insert(User user);
	List<User> queryUserByQueryVo(QueryVo queryVo);
	List<User> queryUserByWhere(User user);
	List<User> queryUserByIds(QueryVo queryVo);
	List<OrderUser> queryOrderUser();
	List<User> queryUserOrder();
}
