package com.zhangxx.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhangxx.dao.ArticleDao;
import com.zhangxx.domain.Article;
import com.zhangxx.service.ArticleService;
@Service ( "ArticleService" )
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	@Qualifier("ArticleDao")
	private ArticleDao articleDao;
	
	@Override
	public boolean add(Article article) {
		Date nowDate = new Date(System.currentTimeMillis());
		if(null==article.getReleasedDate()){
			article.setReleasedDate(nowDate);			
		}else{
			article.setModifiedDate(nowDate);
		}
		
		
		return articleDao.add(article);
	}

	@Override
	public boolean deleteByID(int id) {
		return false;
	}

	@Override
	public boolean updateByID(int id) {
		return false;
	}

	@Override
	public Article findById(int id) {
		return null;
	}

	@Override
	public List<Article> findALL() {
		
		
		return articleDao.findALL();
	}

	@Override
	public List<Article> findPart(int start, int end) {
		return null;
	}

}
