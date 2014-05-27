package com.chzu.tic.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.chzu.tic.model.News;
import com.chzu.tic.model.User;
import com.chzu.tic.util.PageBean;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends AdminBaseAction implements
		ModelDriven<AdminAction>, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private AdminAction adminAction;
	private News news = new News();
	private User user = new User();

	private int page; // �ڼ�ҳ
	private PageBean pageBean; // �����ֲ���Ϣ��bean
	//��ʾ��Ϣ
    private String tip;

	public int getPage() {
		return page;
	}

	public void setPage(int page) { // ��URL���޴˲���,��Ĭ��Ϊ��1ҳ
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * �������ŷ���news_release.jsp
	 * 
	 * @return
	 * @throws Exception
	 */
	public String release() throws Exception {
		return "release";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * ��ӹ��档����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		news.setTitle(request.getParameter("news_title"));
		news.setContent(request.getParameter("news_content"));
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String date = fm.format(new Date());
		Timestamp time = new Timestamp(fm.parse(date).getTime());
		news.setDate(time);
		System.out.println(news.getTitle());
		System.out.println(news.getContent());
		System.out.println(news.getDate());
		adminService.saveNotice(news);
		return "success";
	}

	@Override
	public AdminAction getModel() {
		return adminAction;
	}

	/**
	 * ��������û�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String user() throws Exception {
		List<User> lists = adminService.findAllUser();
		for (User user : lists) {
			System.out.println(user);
		}
		request.setAttribute("lists", lists);
		return "list_user";
	}

	/**
	 * ����Ա����û� ��Ҫ�Դ˷����ĸ��������Ŀ�ֵ��������жϣ� ��public String validateAddoneUser()throws
	 * Exception�����жϣ� ������jquery�ж�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addoneUser() throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		String type = request.getParameter("type1");
		user=adminService.findByName(username);
		if (user.getUsername().equals(username)) {//�û��Ѵ���
			setTip("���û����Ѵ��ڣ�");
			return "input";
		}
		user.setPassword(password);
		user.setRepassword(repassword);
		if (user.getPassword().equals(user.getRepassword())) {
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setType(Integer.parseInt(type));
			adminService.addUser(user);
		}
		return "success";
	}

	/**
	 * ���û���ӽ�����֤
	 * 
	 * @return
	 * @throws Exception
	 */
	public String validateAddoneUser() throws Exception {
		// if(request.getParameter("password")!=request.getParameter("repassword"))
		// {
		// String result="�������벻һ��";
		// request.setAttribute("result", "result");
		//
		// }

		return "admin_addoneUser";
	}

	/**
	 * ���Ź����ҳ��ʾ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// ��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
		pageBean = adminService.queryForPage(5, page);
		return "newsLists";
	}

	/**
	 * deleteOneUser ��getUserList.jsp��ɾ��action��ת���������� �����û�ģ�飬 ɾ��ĳ���û�
	 */
	public String deleteOneUser() throws Exception {
		String userId = request.getParameter("userId");
		Integer id = Integer.parseInt(userId);
		adminService.delete(id);
		// ������ִ��ɾ����������������ִ�в��Ҳ�����������
		List<User> lists = adminService.findAllUser();
		request.setAttribute("lists", lists);
		return "getUsersList";

	}

	/**
	 * showOneNews �༭news����
	 */
	public String showOneNews() throws Exception {
		// �����Ƿ����õ����ݡ�����
		String newsId = request.getParameter("notice.id");
		// System.out.println(newsId);
		Integer id = Integer.parseInt(newsId);
		// ִ�а���NewsID�������š�����
		news = adminService.get(id);
		// System.out.println(news);
		request.setAttribute("news", news);
		return "newsUpdate";

	}

	/**
	 * deleteOneNews
	 */
	public String deleteOneNews() throws Exception {

		news.setId(Integer.parseInt(request.getParameter("notice.id")));
		Integer id = news.getId();
		System.out.println(id);
		adminService.deleteOneNews(id);
		// ��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
		pageBean = adminService.queryForPage(5, page);
		return "newsLists";
	}

	/**
	 * updateOneNews �༭���š�����
	 */
	public String updateOneNews() throws Exception {
		String newsId = request.getParameter("id");
		// System.out.println(newsId);
		news = adminService.get(Integer.parseInt(newsId));
		news.setTitle(request.getParameter("news_title"));
		news.setContent(request.getParameter("news_content"));
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String date = fm.format(new Date());
		Timestamp time = new Timestamp(fm.parse(date).getTime());
		news.setDate(time);
		// System.out.println(news.getTitle());
		// System.out.println(news.getContent());
		// System.out.println(news.getDate());
		adminService.UpdateOneNews(news);
		return "add";
	}

	/**
	 * newsdetails �������顣����
	 */
	public String newsDetails() throws Exception {
		String newsId = request.getParameter("notice.id");
		news = adminService.get(Integer.parseInt(newsId));
		request.setAttribute("news", news);
		return "newsdetails";
	}

}
