package com.chzu.dao;

import java.util.List;

import com.chzu.model.Department;

public interface DepartmentDao {

	/**
	 * ���ݱ�ʶ����������Departmentʵ��
	 */
	Department get(Integer id);

	
	/**
	 * �־û�ָ����Departmentʵ��
	 */
	Integer save(Department Department);

	
	/**
	 * �޸�ָ����Departmentʵ��
	 */
	void update(Department Department);

	
	/**
	 * ɾ��ָ����Departmentʵ��
	 */
	void delete(Department Department);

	
	/**
	 * ���ݱ�ʶ����ɾ��Departmentʵ��
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Departmentʵ��
	 */
	List<Department> findAll();

	
	

}
