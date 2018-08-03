package com.zhangxx.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhangxx.dao.ArticleDao;
import com.zhangxx.domain.Article;

@Repository("ArticleDao")
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {
	
	@Autowired
	public void setSupperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 增加一篇文章
	 */
	@Override
	public boolean add(Article article){
		
		this.getHibernateTemplate().saveOrUpdate(article);
		return true;
	}
	/**
	 * 根据ID删除一篇文章
	 */
	@Override
	public boolean deleteByID(int id){
		
		return false;
	}
	/**
	 * 根据ID修改
	 */
	@Override
	public boolean updateByID(int id){
		return false;
	}
	/**
	 * 根据ID查找一篇文章
	 */
	@Override
	public Article findById(int id){
		return null;
	}
	/**
	 * 查找所有文章
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article>  findALL(){
		String hql = "from  Article";
		
		return (List<Article>) this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 分页查找
	 */
	@Override
	public List<Article> findPart(int start,int end){
		return null;
		
	}
	
	
	
}
