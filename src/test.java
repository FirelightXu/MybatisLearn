import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import Dao.UerDao;
import Dao.UserDaoImpl;
import config.mapper.OrderMapper;
import config.mapper.UserMapper;
import pojo.QueryVo;
import pojo.User;
import pojo.Orders;
import pojo.OrderUser;
//import java.sql.Date;

public class test {
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws Exception{
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	
	public void find() throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Object user = sqlSession.selectOne("test.findUserById","张三");
		System.out.println(user);
		sqlSession.close();
	}
	
	public void insert() throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("xuye");
//		System.out.println(user);
		sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(user.getId());
	}

	public void update() throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(32);
		user.setUsername("lili");
//		System.out.println(user);
		sqlSession.insert("test.updateUser",user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void delete() throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.deleteUser",32);
		sqlSession.commit();
		sqlSession.close();
	}

	
	public void testDao(){
		UerDao userDao = new UserDaoImpl(this.sqlSessionFactory);
		User user =userDao.find(1);
		System.out.println(user);
		
	}
	

	public void testmapper(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.find(1);
		System.out.println(user);
		sqlSession.close();	
	}
	

	public void testmapper2(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryvo = new QueryVo();
		User user = new User();
		user.setUsername("张");
		queryvo.setUser(user);
		List<User> list = userMapper.queryUserByQueryVo(queryvo);
		for(User u :list){
			System.out.println(u);
		}
		sqlSession.close();
	}
	
	
	public void testoedermapper(){
//		Orders o = new Orders();
//		java.util.Date  date=new java.util.Date();
//
//		java.sql.Date  data1=new java.sql.Date(date.getTime());
//		System.out.println(data1);
//		o.setCreatetime(data1);
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.queryOrderAll();
		for(Orders o :list){
			System.out.println(o);
		}
	}
	
	public void testusermapper(){
		
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
//		user.setSex("1");
		user.setUsername("张");
		List<User> list = userMapper.queryUserByWhere(user);
		for(User o :list){
			System.out.println(o);
		}
		sqlSession.close();
	}
	
	
	public void testuserforeach(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo queryvo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(24);
		queryvo.setIds(ids);
		List<User> list = userMapper.queryUserByIds(queryvo);
		for(User o :list){
			System.out.println(o);
		}
		sqlSession.close();
	}
	
	
	public void testuserorder(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<OrderUser>  orderuser = userMapper.queryOrderUser();
		for(OrderUser o :orderuser){
			System.out.println(o);
		}
		sqlSession.close();
	}
	@Test
	public void testQueryUserOrder(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.queryUserOrder();
		for(User o :list){
			System.out.println(o);
		}
		sqlSession.close();
	}
}
