package Dao;

import pojo.User;

public interface UerDao {
	User find(Integer id);
	void insert(User user);
	void delete(int id);
}
