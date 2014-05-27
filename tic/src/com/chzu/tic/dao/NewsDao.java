package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.User;
import com.chzu.tic.model.News;

public interface NewsDao {
	
	/**
	 * ���ݱ�ʶ����������Newsʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Newsʵ���ı�ʶ����ֵ
	 * @return ����ָ����ʶ���Զ�Ӧ��Newsʵ��
	 */
	News get(Integer id);

	
	/**
	 * �־û�ָ����Newsʵ��
	 * 
	 * @param news
	 *            ��Ҫ���־û���Newsʵ��
	 * @return ����Newsʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(News news);

	
	/**
	 * �޸�ָ����Newsʵ��
	 * 
	 * @param news
	 *            ��Ҫ���޸ĵ�Newsʵ��
	 */
	void update(News news);

	
	/**
	 * ɾ��ָ����Newsʵ��
	 * 
	 * @param news
	 *            ��Ҫ��ɾ����Newsʵ��
	 */
	void delete(News news);

	
	/**
	 * ���ݱ�ʶ����ɾ��Newsʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Newsʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Newsʵ��
	 * 
	 * @return �������ݿ���ȫ����Newsʵ��
	 */
	List<News> findAll();
	
	/**
	 * 
	 * ���½��з�ҳ��ѯ����Ҫ�ķ�����ͨ���̳�UtilHibernateDaoSupportʵ�֣�
	 * ��������д
	 */
	public List<News> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<User> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<User> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
	

}
