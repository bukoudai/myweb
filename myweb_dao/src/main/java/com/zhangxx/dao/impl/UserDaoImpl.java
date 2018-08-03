package com.zhangxx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhangxx.dao.UserDao;
import com.zhangxx.domain.User;


@Repository("UserDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {


	@Autowired
	public void setSupperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public User findByUsername(String username) throws SQLException {
		String hql ="from User where username=?";
		List<User> findByNamedParam = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(findByNamedParam.size()==0){
			return null;
		}
		
		return findByNamedParam.get(0);
		
	}

	@Override
	public void save(User user) throws SQLException {
		this.getHibernateTemplate().save(user);
		
		
	}

	@Override
	public User findByCode(String code) throws SQLException {
		return null;
	}

	@Override
	public void update(User existUser) throws SQLException {

	}

	@Override
	public User login(User user) throws SQLException {
		

		String hql ="from User where username=? and password=?";
		List<User> findByNamedParam = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(),user.getPassword());
		if(findByNamedParam.size()==0||findByNamedParam.size()!=1){
			return null;
		}
		return findByNamedParam.get(0);
	}

}
