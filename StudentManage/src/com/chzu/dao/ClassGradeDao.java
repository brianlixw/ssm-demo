package com.chzu.dao;

import java.util.List;

import com.chzu.model.ClassGrade;

public interface ClassGradeDao {

	/**
	 * ���ݱ�ʶ����������ClassGradeʵ��
	 */
	ClassGrade get(Integer id);

	
	/**
	 * �־û�ָ����ClassGradeʵ��
	 */
	Integer save(ClassGrade ClassGrade);

	
	/**
	 * �޸�ָ����ClassGradeʵ��
	 */
	void update(ClassGrade ClassGrade);

	
	/**
	 * ɾ��ָ����ClassGradeʵ��
	 */
	void delete(ClassGrade ClassGrade);

	
	/**
	 * ���ݱ�ʶ����ɾ��ClassGradeʵ��
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����ClassGradeʵ��
	 */
	List<ClassGrade> findAll();
	
	/**
	 * ���ݰ༶���Ʋ�ѯ
	 * @param name
	 * @return
	 */
	ClassGrade findByName(String name);

	
	

}
