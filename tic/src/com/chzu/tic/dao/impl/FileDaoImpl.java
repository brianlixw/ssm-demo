package com.chzu.tic.dao.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.model.File;
import com.chzu.tic.util.UtilHibernateDaoSupport;

public class FileDaoImpl extends UtilHibernateDaoSupport implements FileDao {

	@Override
	public File get(Integer id) {
		return getHibernateTemplate().get(File.class, id);
	}

	/**
	 * �ϴ��ļ�
	 */
	@Override
	public Integer save(File file) {
		return (Integer) getHibernateTemplate().save(file);
	}

	@Override
	public void update(File file) {
		getHibernateTemplate().update(file);
	}

	@Override
	public void delete(File file) {
		getHibernateTemplate().delete(file);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * ��ѯ���е��ϴ��ļ�
	 * 
	 * @author �������е��ϴ��ļ�
	 */
	@Override
	public List<File> findAll() {
		String queryString = "from File";
		return (List<File>) getHibernateTemplate().find(queryString);
	}
  
	/**
	 * Ϊ��ʦ�ṩ�����ļ�����ѯ�ϴ����ļ� �˴����е��Ǿ�׼ƥ��
	 * 
	 * @author ���ط����������ϴ��ļ�
	 */
	@Override
	public List<File> findByName(String name) {
		return (List<File>) getHibernateTemplate().find(
				"from File as f where f.name=?", name);
	}
}
