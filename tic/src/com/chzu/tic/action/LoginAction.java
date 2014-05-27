package com.chzu.tic.action;

import com.chzu.tic.model.User;
import com.opensymphony.xwork2.ActionContext;
import static com.chzu.tic.service.AdminService.*;

public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	public static String ADMIN_RESULT = "admin_result";// ��Ϊ����Ա��¼�ɹ��ķ��ؽ����
	public static String TEACHER_RESULT = "teacher_result";// ��Ϊ��ʦ��¼�ɹ��ķ��ؽ����
	public static String STUDENT_RESULT = "student_result";// ��Ϊѧ����¼�ɹ��ķ��ؽ����
	private String verifycode;// ��֤��
	private User user;
	// �����¼�����ʾ��Ϣ
	private String tip;

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return this.tip;
	}

	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�rand����
		String ver2 = (String) ctx.getSession().get("rand");
		if (verifycode.equalsIgnoreCase(ver2)) {
			// ����ҵ���߼������������¼����
			int result = adminService.validLogin(getUser());
			// ��¼���Ϊ����Ա
			if (result == LOGIN_ADMIN) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession().put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_ADMIN);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return ADMIN_RESULT;
			}
			// ��¼���Ϊ��ʦ
			else if (result == LOGIN_TEACHER) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession()
						.put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_TEACHER);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return TEACHER_RESULT;
			}
			// ��¼���Ϊѧ��
			else if (result == LOGIN_STUDENT) {
				ctx.getSession().put(WebConstant.USERNAME, user.getUsername());
				ctx.getSession()
						.put(WebConstant.LOGIN_TYPE, WebConstant.LOGIN_STUDENT);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return STUDENT_RESULT;
			}
			// �û��������벻ƥ��
			else {
				setTip("�û���/���벻ƥ��");
				return ERROR;
			}
		}
		// ��֤�벻ƥ��
		else {
			setTip("��֤�벻ƥ��,����������");
			return ERROR;
		}
	}
}
