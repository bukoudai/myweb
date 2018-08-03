package com.zhangxx.utils;

import com.zhangxx.domain.User;

public class UserUtils {

	private UserUtils() {

	}
	
	//设置UID 设置激活状态 设置激活码
	public static void userInit(User user){
		
		String code = UUIDUtils.getUUID();
		user.setState(1);
		user.setCode(code);
	
	}
	
	
	
}
