package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.File;

public interface FileDao {
	/**
	 * ���ݱ�ʶ����������Fileʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Fileʵ���ı�ʶ����ֵ
	 * @return ����ָ����ʶ���Զ�Ӧ��Fileʵ��
	 */
	File get(Integer id);

	/**
	 * �־û�ָ����Fileʵ��
	 * 
	 * @param file
	 *            ��Ҫ���־û���Fileʵ��
	 * @return ����Fileʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(File file);

	
	/**
	 * �޸�ָ����Fileʵ��
	 * 
	 * @param file
	 *            ��Ҫ���޸ĵ�Fileʵ��
	 */
	void update(File file);

	
	/**
	 * ɾ��ָ����Fileʵ��
	 * 
	 * @param file
	 *            ��Ҫ��ɾ����Fileʵ��
	 */
	void delete(File file);

	
	/**
	 * ���ݱ�ʶ����ɾ��fileʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����fileʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Fileʵ��
	 * 
	 * @return �������ݿ���ȫ����Fileʵ��
	 */
	List<File> findAll();
	
	/**
	 * 
	 * ���½��з�ҳ��ѯ����Ҫ�ķ�����ͨ���̳�UtilHibernateDaoSupportʵ�֣�
	 * ��������д
	 */
	public List<File> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<File> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<File> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
	
	/**
	 * �����ļ�����ѯ�ļ�
	 * 
	 * @param name
	 *            �ļ���
	 * @return ���ط���������Fileʵ��
	 */
	List<File> findByName(String name);


}
