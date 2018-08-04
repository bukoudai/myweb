package com.zhangxx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;
import com.zhangxx.domain.Article;
import com.zhangxx.domain.User;
import com.zhangxx.service.ArticleService;
import com.zhangxx.service.UserService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller()
@Scope ("prototype") 
public class AdminAction extends ActionSupport{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//ApplicationContext app  = (ApplicationContext) ServletActionContext.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	
	private User user;
	private Article article;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String addArticle(){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			if(!articleService.add(article)){
				
			response.getWriter().write("0");
				
				return null;
			}
			response.getWriter().write("1");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 日志编辑界面
	 * @return
	 */
	public String editUI(){
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	/**
	 * 用户登陆
	 * @return
	 */
	public String login(){
		try {
			//UserService userService = (UserService) app.getBean("UserService");
		
	
			User loginUser = userService.login(user);
			
			if(loginUser==null){
				
				this.addActionError("用户名或密码错误!");
				return ActionSupport.ERROR;
			}
			
			HttpSession httpSession = ServletActionContext.getRequest().getSession();
			
			httpSession.setAttribute("loginUser", loginUser);
			this.addActionMessage("登陆成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ActionSupport.SUCCESS;
		
	}
	
	/**
	 * 用户名检查(ajax请求)
	 * 
	 */
	public String checkUserNameAjax(){
		try {
			//UserService userService = (UserService) app.getBean("UserService");
			PrintWriter writer = ServletActionContext.getResponse().getWriter();
			//判断用户名是否重复
			if(userService.checkUserName(user.getUsername())==null){
				writer.write("0");
				
				return null;
			}
			writer.write("1");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
		
	}
	
	/**
	 * 注册界面
	 * @return
	 */
	public String regist(){
		return ActionSupport.SUCCESS;
		
	}
	/**
	 * 注册用户的异步请求 0代表已注册 1代表注册成功
	 * @return
	 */
	public String registAjax(){
		try {
			//UserService userService = (UserService) app.getBean("UserService");
			PrintWriter writer = ServletActionContext.getResponse().getWriter();
			//判断用户名是否重复
			if(userService.checkUserName(user.getUsername())!=null){
				writer.write("0");
				
				return null;
			}
			userService.regist(user);
			writer.write("1");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
