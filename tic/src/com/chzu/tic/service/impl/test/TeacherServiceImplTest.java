package com.chzu.tic.service.impl.test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.chzu.tic.dao.UserDao;
import com.chzu.tic.model.User;
import com.chzu.tic.service.impl.TeacherServiceImpl;
import com.chzu.tic.util.PageBean;

/**
 * ���߼���TeacherServiceImpl���в���
 * 
 * @author Administrator
 * 
 */
public class TeacherServiceImplTest {
	public static TeacherServiceImpl teacherServiceImpl;
	private int page; // �ڼ�ҳ
	private PageBean pageBean; // ������ҳ��Ϣ��bean
	@Autowired
	@Qualifier("userDao")
	private static UserDao userDao;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	public static void setUserDao(UserDao userDao) {
		TeacherServiceImplTest.userDao = userDao;
	}

	// ����֮ǰ������spring�����ļ�
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("���������ļ�����");
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[] { "src/applicationContext.xml" });

		System.out.println("���������ļ��ɹ�");
		//��ȡspring�����ļ��ж�Service����ע���beanֵ
		teacherServiceImpl = (TeacherServiceImpl) context
				.getBean("teacherService");
		userDao = (UserDao) context.getBean("userDao");
	}

	/**
	 * ���Զ��һ��ѯ���ܲ���ȡ������
	 * ��������һ�Զ࣬���ڷ�ҳ
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRueryPassForPage() {
		int pageSize = 5;
		String state="��ͨ��";
		// ���ж��һ��ѯ����ѯ�Ľ��ΪUser�����list���ϣ�����ÿһ��User����
		// ��װ�����Ӧ��Project����
		final String hql = "from User as u where u.project is not null and u.state=? "; // ���һ��ѯ
		int allRow = getUserDao().getAllRowCount(hql,state); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<User> list = getUserDao().findByPage(hql,state, offset, length); // "һҳ"�ļ�¼
//		List<User> listTrue = new ArrayList<User>();
//		List<User> listFalse = new ArrayList<User>();
//		for (User user : list) {
//			System.out.println(user.getUsername());
//			System.out.println(user.getProject().getName());
//
//		}
		for (User user : list) {
//			System.out.println(user.getState());
//			if(user.getState().equals("��ͨ��")){
//				listTrue.add(user);
//			}
//			else if(user.getState().equals("δͨ��")) {
//				listFalse.add(user);
//			}
			System.out.println(user.getUsername());
			System.out.println(user.getProject().getName());
		}
//		System.out.println(listTrue.size());
//		for (User user : listFalse) {
//		System.out.println(user.getUsername());
//		System.out.println(user.getProject().getName());
//
//	}
	}

}
