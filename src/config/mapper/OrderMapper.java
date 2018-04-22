package config.mapper;

import java.util.List;

import pojo.Orders;
import pojo.User;

public interface OrderMapper {
//	public List<Orders> selectOrdersList();
//	public List<Orders> selectOrders();
//	public List<User> selectUserList();
	List<Orders> queryOrderAll();
}
