package Dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pojo.User;

public class UserDaoImpl implements UerDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public User find(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
//		sqlSession.close();
		return user;
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(user.getId());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
	}

}
