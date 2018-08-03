package com.zhangxx.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangxx.dao.UserDao;
import com.zhangxx.domain.User;
import com.zhangxx.service.UserService;
import com.zhangxx.utils.UserUtils;
@Service ( "UserService" )
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("UserDao")
	private UserDao udi;
	
	@Override
	public void regist(User user) throws SQLException {
		
		//ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
			
		//UserDao udi = (UserDao) applicationContext.getBean("UserDao");
		
		//初始化user 
		UserUtils.userInit(user);
		udi.save(user);
	

	}
	/**
	 * @param	username 
	 * @return	成功返回查询到的用户   ,失败返回NULL
	 * @throws SQLException
	 */
	@Override
	public User checkUserName(String username) throws SQLException {
		//UserDao udi = (UserDao) BeanFactory.getBean("UserDao");
		
	

		return  udi.findByUsername(username);
	}

	/**
	 * 
	 * @param user 登陆的用户
	 * @return 成功返回用户   ,失败返回NULL
	 * @throws SQLException
	 */
	@Override
	public User login(User user) throws SQLException{
		
		//UserDao udi = (UserDao) BeanFactory.getBean("UserDao");
		
		return udi.login(user);
	}
	

}
