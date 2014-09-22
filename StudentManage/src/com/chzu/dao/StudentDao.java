package com.chzu.dao;

import java.util.List;

import com.chzu.model.Student;

public interface StudentDao {

	/**
	 * ���ݱ�ʶ����������studentʵ��
	 */
	Student get(Integer id);

	
	/**
	 * �־û�ָ����studentʵ��
	 */
	Integer save(Student student);

	
	/**
	 * �޸�ָ����studentʵ��
	 */
	void update(Student student);
	
	/**
	 * �޸�ѧ��������Ϣ
	 */
	void update(String hql);
	
	/**
	 * ɾ��ָ����studentʵ��
	 */
	void delete(Student student);

	
	/**
	 * ���ݱ�ʶ����ɾ��studentʵ��
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����studentʵ��
	 */
	List<Student> findAll();

	
	/**
	 * �����û����������ѯ�û�
	 * 
	 */
	List<Student> findByNameAndPass(Student student);

	
	/**
	 * �����û�����ѯ
	 * 
	 */
	Student findByName(String name);

	
	/**
	 * 
	 * ���½��з�ҳ��ѯ����Ҫ�ķ�����ͨ���̳�UtilHibernateDaoSupportʵ�֣�
	 * ��������д
	 */
	public List<Student> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<Student> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<Student> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);

}
