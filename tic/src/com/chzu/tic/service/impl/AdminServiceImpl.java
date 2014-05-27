package com.chzu.tic.service.impl;

import java.util.List;

import com.chzu.tic.dao.FileDao;
import com.chzu.tic.dao.NewsDao;
import com.chzu.tic.dao.OnlineDao;
import com.chzu.tic.dao.ProjectDao;
import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.service.AdminService;
import com.chzu.tic.util.PageBean;

public class AdminServiceImpl implements AdminService {
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

	/**
	 * �Թ���Ա�������֤��¼
	 * @return -1Ϊ��¼ʧ�ܣ�0Ϊ����Ա��¼ 1Ϊ��ʦ��¼ 2Ϊѧ����¼
	 */
	@Override
	public int validLogin(User user) {
		if (userDao.findByNameAndPass(user).size() >= 1) {
			int type = userDao.findByNameAndPass(user).get(0).getType();// ��ȡ�û�����
			if (type == 0) {// ����Ա��¼��0�������Ա
				return LOGIN_ADMIN;
			} else if (type == 1) {// ��ʦ��¼��1������ʦ
				return LOGIN_TEACHER;
			} else if (type == 2) {// ѧ����¼��2����ѧ��
				return LOGIN_STUDENT;
			}
			return LOGIN_FAIL;
		} else {
			return LOGIN_FAIL;
		}
	}

	//��������
	@Override
	public boolean saveNotice(News news) {
		newsDao.save(news);
		return true;
	}
//����û�
	@Override
	public boolean addUser(User user) {
		userDao.save(user);
		return true;
	}

	public User findByName(String name){
		return userDao.findByName(name);
	}
	
//���ѧ������ʦ�û�
	@Override
	public List<User> findAllUser() {
		List<User> userLists=userDao.findByAdmin();
		for(User user:userLists)
		{
			if(user.getType().equals(1))
			{
				user.setTypename("��ʦ");
			}
			if(user.getType().equals(2))
			{
				user.setTypename("ѧ��");
			}
		}
		return userLists;
	}

	//ɾ����ʦ����ѧ��
	@Override
	public boolean delete(Integer id) {
		userDao.delete(id);
		return true;
	}

	@Override
	public News get(Integer id) {
		News news=newsDao.get(id);
		return news;
	}

	@Override
	public boolean deleteOneNews(Integer id) {
		newsDao.delete(id);
		return true;
	}

	@Override
	public boolean UpdateOneNews(News news) {
		newsDao.update(news);
		return true;
	}
	
	@Override
    public PageBean queryForPage(int pageSize,int page){

       final String hql = "from News";        //��ѯ���
       int allRow = newsDao.getAllRowCount(hql);    //�ܼ�¼��
       int totalPage = PageBean.countTotalPage(pageSize, allRow);    //��ҳ��
       final int offset = PageBean.countOffset(pageSize, page);    //��ǰҳ��ʼ��¼
       final int length = pageSize;    //ÿҳ��¼��
       final int currentPage = PageBean.countCurrentPage(page);
       List<News> list = newsDao.findByPage(hql, offset, length);        //"һҳ"�ļ�¼
       
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

}
