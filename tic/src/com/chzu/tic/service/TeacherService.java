package com.chzu.tic.service;

import java.util.List;

import com.chzu.tic.util.*;
import com.chzu.tic.model.File;
import com.chzu.tic.model.Project;
import com.chzu.tic.model.User;

public interface TeacherService {
	
	 /**
 	 * ��֤�û��ϴ����ļ��Ƿ��Ѿ�����
 	 */
	public Boolean exit(String name);

	/**
	 * ���ϴ����ļ������ƺ�·��д�����ݿ�
	 */
	public void upload(File file);
	
	/**
	 * 
	 *��ѯ���е��ļ�
	 */
	public List<File> fileFindAll();
	
	/**
     * �ļ���ҳ��ѯ
     * @param pageSize ÿҳ��С
     * @param page ��ǰ�ڼ�ҳ
     * @return ��װ�˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryForPage(int pageSize,int currentPage);
    
    /**
     * ������Ŀ��ҳ��ѯ
     * @param pageSize ÿҳ��С
     * @param page ��ǰ�ڼ�ҳ
     * @return ��װ�˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryProjectForPage(int pageSize,int currentPage);
    
    /**
     *������Ŀ�Ƿ�ͨ����ҳ��ѯ
     *�õ������ݰ���ͨ����δͨ��
     * @param pageSize ÿҳ��С
     * @param page ��ǰ�ڼ�ҳ
     * @param isPass ɸѡͨ����δͨ����isPassֻ��Ϊtrue��false,ͨ��true,δͨ��false
     * @return ��װ�˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryPassOrNoPassForPage(int pageSize,int page,boolean isPass);
    
    /**
	 * ����idɾ���ļ�
	 */
    public File getFile(Integer id);
    
    /**
	 * ����idɾ���ļ�
	 */
    public void deleteFile(Integer id);
    
    /**
	 * �������Ʋ�ѯ������Ŀ
	 */
    public List<Project> findProjectByName(String ProjectName);
    
    /**
     * ������Ŀidɾ����Ŀ
     * @param id ��Ŀid
     */
    public void deleteProject( Integer id);
    
    /**
     * ������Ŀ
     * @param project Project�����
     */
    public void updateProject(Project project);
    
    /**
     * ��ӱ�����Ŀ
     * 
     */
    public void addProject(Project project);
    
    /**
     * ��׼ѧ������
     */
    public void updateApprove(User user);
    
    /**
     * ȡ��ѧ������
     */
    public void updateCancel(User user);
    
    /**
     * ���ѧ����Ϣ
     */
    public User getUser(Integer id);
    
    	
}
