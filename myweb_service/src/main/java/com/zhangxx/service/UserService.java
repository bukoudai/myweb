package com.zhangxx.service;

import java.sql.SQLException;

import com.zhangxx.domain.User;

public interface UserService {

	void regist(User user) throws SQLException;

	User checkUserName(String username) throws SQLException;

	User login(User user) throws SQLException;


	
}
