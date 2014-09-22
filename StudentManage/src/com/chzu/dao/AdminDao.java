package com.chzu.dao;

import java.util.List;

import com.chzu.model.Admin;

public interface AdminDao {

	/**
	 * ���ݱ�ʶ����������adminʵ��
	 */
	Admin get(Integer id);

	
	/**
	 * �־û�ָ����adminʵ��
	 */
	Integer save(Admin admin);

	
	/**
	 * �޸�ָ����adminʵ��
	 */
	void update(Admin admin);

	
	/**
	 * ɾ��ָ����adminʵ��
	 */
	void delete(Admin admin);

	
	/**
	 * ���ݱ�ʶ����ɾ��adminʵ��
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����adminʵ��
	 */
	List<Admin> findAll();

	
	/**
	 * �����û����������ѯ�û�
	 */
	List<Admin> findByNameAndPass(Admin admin);

	
	/**
	 * �����û�����ѯ
	 * 
	 */
	Admin findByName(String name);

}
