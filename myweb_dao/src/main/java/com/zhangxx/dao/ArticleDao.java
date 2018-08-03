package com.zhangxx.dao;

import java.util.List;

import com.zhangxx.domain.Article;

public interface ArticleDao {
	/**
	 * 增加一篇文章
	 */
	boolean add(Article article);
	/**
	 * 根据ID删除一篇文章
	 */
	boolean deleteByID(int id);
	/**
	 * 根据ID修改
	 */
	boolean updateByID(int id);
	/**
	 * 根据ID查找一篇文章
	 */	
	Article findById(int id);
	/**
	 * 查找所有文章
	 */
	List<Article> findALL();
	/**
	 * 分页查找
	 */
	List<Article> findPart(int start, int end);

}
