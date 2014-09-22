package com.chzu.dao;

import java.util.List;

import com.chzu.model.Professional;

public interface ProfessionalDao {

	/**
	 * ���ݱ�ʶ����������Professionalʵ��
	 */
	Professional get(Integer id);

	
	/**
	 * �־û�ָ����Professionalʵ��
	 */
	Integer save(Professional Professional);

	
	/**
	 * �޸�ָ����Professionalʵ��
	 */
	void update(Professional Professional);

	
	/**
	 * ɾ��ָ����Professionalʵ��
	 */
	void delete(Professional Professional);

	
	/**
	 * ���ݱ�ʶ����ɾ��Professionalʵ��
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Professionalʵ��
	 */
	List<Professional> findAll();

	
	

}
