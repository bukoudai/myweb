package com.zhangxx.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.zhangxx.domain.Article;
import com.zhangxx.service.ArticleService;

@Controller()
@Scope ("prototype") 
public class VisitAction extends ActionSupport  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8242073355822625342L;
	@Autowired
	private ArticleService articleService;

	
	private Article article;


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}
	
	public String findAllArticle(){
		
		List<Article> articlelist = articleService.findALL();
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.set("articlelist", articlelist);
		
		return SUCCESS;
	}
	public String findByArticleID(){
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
}
