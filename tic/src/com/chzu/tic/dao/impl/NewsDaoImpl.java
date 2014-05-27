package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.NewsDao;
import com.chzu.tic.model.News;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class NewsDaoImpl extends UtilHibernateDaoSupport implements NewsDao {

	@Override
	public News get(Integer id) {
		return getHibernateTemplate().get(News.class, id);
	}

	@Override
	public Integer save(News news) {
		return (Integer) getHibernateTemplate().save(news);
	}

	@Override
	public void update(News news) {
		getHibernateTemplate().update(news);
	}

	@Override
	public void delete(News news) {
		getHibernateTemplate().delete(news);
	}

	/**
	 * ɾ��ָ�������� һ��һ����ɾ��
	 */
	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * �鿴�������ţ��б���ʽ��
	 */
	
	@Override
	public List<News> findAll() {
		String queryString = "from News";
		return (List<News>) getHibernateTemplate().find(queryString);
	}

}
