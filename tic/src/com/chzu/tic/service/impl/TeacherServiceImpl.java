package com.chzu.tic.service.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.dao.NewsDao;
import com.chzu.tic.dao.OnlineDao;
import com.chzu.tic.dao.ProjectDao;
import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.File;
import com.chzu.tic.model.Project;
import com.chzu.tic.model.User;
import com.chzu.tic.service.TeacherService;
import com.chzu.tic.util.PageBean;

public class TeacherServiceImpl implements TeacherService {

	private FileDao fileDao;
	private NewsDao newsDao;
	private OnlineDao onlineDao;
	private ProjectDao projectDao;
	private UserDao userDao;

	public FileDao getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public OnlineDao getOnlineDao() {
		return onlineDao;
	}

	public void setOnlineDao(OnlineDao onlineDao) {
		this.onlineDao = onlineDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    
	@Override
     public PageBean queryForPage(int pageSize,int page){

        final String hql = "from File";        //��ѯ���
        int allRow = fileDao.getAllRowCount(hql);    //�ܼ�¼��
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
        final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
        final int length = pageSize;    //ÿҳ��¼��
        final int currentPage = PageBean.countCurrentPage(page);
        List<File> list = fileDao.findByPage(hql, offset, length);        //"һҳ"�ļ�¼
        
        //�ѷ�ҳ��Ϣ���浽Bean��
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
    }

	@Override
	public PageBean queryProjectForPage(int pageSize, int page) {
		final String hql = "from Project";        //��ѯ���
        int allRow = projectDao.getAllRowCount(hql);    //�ܼ�¼��
        int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
        final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
        final int length = pageSize;    //ÿҳ��¼��
        final int currentPage = PageBean.countCurrentPage(page);
        List<Project> list =projectDao.findByPage(hql, offset, length);        //"һҳ"�ļ�¼
        
        //�ѷ�ҳ��Ϣ���浽Bean��
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);    
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRow(allRow);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(list);
        pageBean.init();
        return pageBean;
	}
	
	@Override
	public PageBean queryPassOrNoPassForPage(int pageSize, int page,boolean isPass) {
		String state = "";
		if (isPass) {//�����Ѿ�ͨ����˵ı�����Ŀ
			state = "��ͨ��";
		} else {//����Ϊͨ����˵ı�����Ŀ
			state = "δͨ��";
		}
		// ���ж��һ��ѯ����ѯ�Ľ��ΪUser�����list���ϣ�����ÿһ��User����
		// ��װ�����Ӧ��Project����
		final String hql = "from User as u where u.project is not null and u.state=? "; // ���һ��ѯ
		int allRow = getUserDao().getAllRowCount(hql, state); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = getUserDao().findByPage(hql, state, offset, length); // "һҳ"�ļ�¼
		
		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	@Override
	public Boolean exit(String name) {
		List<File> listFile=fileDao.findByName(name);
		if(listFile.size()>0){//��ͬ�ļ����Ѵ���
			return true;
		}
		return false;
	}

	@Override
	public void upload(File file) {
            fileDao.save(file);
	}
	
	@Override
	public List<File> fileFindAll(){
		return fileDao.findAll();
	}
	
	@Override
	public File getFile(Integer id){
		return fileDao.get(id);
	}

	@Override
	public void deleteFile(Integer id) {
		fileDao.delete(id);
	}

	@Override
	public List<Project> findProjectByName(String ProjectName) {
		return projectDao.findByName(ProjectName);
	}

	@Override
	public void deleteProject(Integer id) {
		projectDao.delete(id);
		
	}

	@Override
	public void updateProject(Project project) {
		projectDao.update(project);
		
	}

	@Override
	public void addProject(Project project) {
		projectDao.save(project);
		
	}

	@Override
	public void updateApprove(User user) {
		userDao.update(user);
		
	}

	@Override
	public void updateCancel(User user) {
		userDao.update(user);
	}

	@Override
	public User getUser(Integer id) {
		return userDao.get(id);
	}

}
