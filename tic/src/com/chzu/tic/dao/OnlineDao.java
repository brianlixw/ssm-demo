package com.chzu.tic.dao;

import java.util.List;

import com.chzu.tic.model.Online;

public interface OnlineDao {
	/**
	 * ���ݱ�ʶ����������Onlineʵ��
	 * 
	 * @param id
	 *            ��Ҫ���ص�Onlineʵ���ı�ʶ����ֵ
	 * @return ����ָ����ʶ���Զ�Ӧ��Onlineʵ��
	 */
	Online get(Integer id);

	
	/**
	 * �־û�ָ����Onlineʵ��
	 * 
	 * @param online
	 *            ��Ҫ���־û���Onlineʵ��
	 * @return ����Onlineʵ�����־û���ı�ʶ����ֵ
	 */
	Integer save(Online online);

	
	/**
	 * �޸�ָ����Onlineʵ��
	 * 
	 * @param news
	 *            ��Ҫ���޸ĵ�Onlineʵ��
	 */
	void update(Online online);

	
	/**
	 * ɾ��ָ����Onlineʵ��
	 * 
	 * @param online
	 *            ��Ҫ��ɾ����Onlineʵ��
	 */
	void delete(Online online);

	
	/**
	 * ���ݱ�ʶ����ɾ��Onlineʵ��
	 * 
	 * @param id
	 *            ��Ҫ��ɾ����Onlineʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);

	
	/**
	 * ��ѯȫ����Onlineʵ��
	 * 
	 * @return �������ݿ���ȫ����Onlineʵ��
	 */
	List<Online> findAll();
}
