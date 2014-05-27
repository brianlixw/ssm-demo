package com.chzu.tic.service;

import java.util.List;

import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.util.PageBean;

public interface AdminService {
	// ��¼ʧ��
	public static final int LOGIN_FAIL = -1;
	// �Թ���Ա��ݵ�¼
	public static final int LOGIN_ADMIN = 0;
	// ����ʦ��ݵ�¼
	public static final int LOGIN_TEACHER = 1;
	// ��ѧ����ݵ�¼
	public static final int LOGIN_STUDENT = 2;

	int validLogin(User admin);//�Թ���Ա�������֤��¼
	
	boolean saveNotice(News news);//������Ÿ�ʾ
	
	boolean addUser(User user);//����û�
	
	List<User> findAllUser();
	
	User findByName(String name);
	
	boolean delete(Integer id);
	
	News get(Integer id);
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	boolean deleteOneNews(Integer id);
	
	/**
	 * �༭����
	 * @param news
	 * @return
	 */
	boolean UpdateOneNews(News news);
	
	/**
     * ���ŷ�ҳ��ѯ
     * @param pageSize ÿҳ��С
     * @param page ��ǰ�ڼ�ҳ
     * @return ��װ�˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);

}
