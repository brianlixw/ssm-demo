package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.Project;

public interface ProjectDao {

	/**
	 * ���ݱ�ʶ����������Projectʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Projectʵ���ı�ʶ����ֵ
	 * @return ����ָ����ʶ���Զ�Ӧ��Projectʵ��
	 */
    Project get(Integer id);
	
	
	/**
	 * �־û�ָ����Projectʵ��
	 * 
	 * @param project
	 *            ��Ҫ���־û���Projectʵ��
	 * @return ����Projectʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(Project project);

	
	/**
	 * �޸�ָ����Projectʵ��
	 * 
	 * @param news
	 *            ��Ҫ���޸ĵ�Projectʵ��
	 */
	void update(Project project);
	
	/**
	 * ���ݱ�ʶ����ɾ��Projectʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Projectʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Projectʵ��
	 * 
	 * @return �������ݿ���ȫ����Projectʵ��
	 */
	List<Project> findAll();
	
	/**
	 * ������Ŀ����ѯ������Ŀ
	 * �Ժ�ģ����ѯ
	 * @param name
	 *            �ļ���
	 * @return ���ط���������ʵ��
	 */
	List<Project> findByName(String name);
	
	/**
	 * 
	 * ���½��з�ҳ��ѯ����Ҫ�ķ�����ͨ���̳�UtilHibernateDaoSupportʵ�֣�
	 * ��������д
	 */
	public List<Project> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<Project> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<Project> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
}
