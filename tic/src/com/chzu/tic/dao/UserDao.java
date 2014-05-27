package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.User;

public interface UserDao {

	/**
	 * ���ݱ�ʶ����������Userʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Userʵ���ı�ʶ����ֵ
	 * @return ����ָ����ʶ���Զ�Ӧ��Userʵ��
	 */
	User get(Integer id);

	
	/**
	 * �־û�ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ���־û���Userʵ��
	 * @return ����Userʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(User user);

	
	/**
	 * �޸�ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ���޸ĵ�Userʵ��
	 */
	void update(User user);

	
	/**
	 * ɾ��ָ����Userʵ��
	 * 
	 * @param user
	 *            ��Ҫ��ɾ����Userʵ��
	 */
	void delete(User user);

	
	/**
	 * ���ݱ�ʶ����ɾ��Userʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Userʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Userʵ��
	 * 
	 * @return �������ݿ���ȫ����Userʵ��
	 */
	List<User> findAll();

	
	/**
	 * �����û����������ѯ�û�
	 * 
	 * @param user
	 *            ����ָ���û�����������û�
	 * @return ���ط���ָ���û�����������û�����
	 */
	List<User> findByNameAndPass(User user);

	
	/**
	 * �����û�����ѯѧ������ʦ
	 * 
	 * @param name
	 *            ѧ������ʦ���û���
	 * @return ���ط����û�����ѧ������ʦ
	 */
	User findByName(String name);

	
	/**
	 * ���ݹ���Ա��ѯѧ������ʦ��������ֵ1��2��1������ʦ��2����ѧ����
	 * @return ���ظù���Ա��Ӧ������ѧ������ʦ
	 */
	List<User> findByAdmin();
	
	/**
	 * 
	 * ���½��з�ҳ��ѯ����Ҫ�ķ�����ͨ���̳�UtilHibernateDaoSupportʵ�֣�
	 * ��������д
	 */
	public List<User> findByPage(final String hql, final int offset,
			final int pageSize);
	public List<User> findByPage(final String hql, final Object value,
			final int offset, final int pageSize);
	public List<User> findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	public int getAllRowCount(String hql);
	public int getAllRowCount(String hql, Object value);
	public int getAllRowCount(String hql, Object[] values);
}
