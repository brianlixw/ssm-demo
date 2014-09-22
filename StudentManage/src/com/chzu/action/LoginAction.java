package com.chzu.action;

import com.chzu.model.Admin;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	public static String ADMIN_RESULT = "admin_result";// ��Ϊ����Ա��¼�ɹ��ķ��ؽ����
	private String verifycode;// ��֤��
	private Admin admin;
	// �����¼�����ʾ��Ϣ
	private String tip;

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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
			int result = adminService.validLogin(getAdmin());
			// ��¼���Ϊ����Ա
			if (result == 0) {
				ctx.getSession().put(WebConstant.USERNAME, admin.getUsername());
				ctx.getSession().put(WebConstant.LOGIN_TYPE,
						WebConstant.LOGIN_ADMIN);
				setTip("���Ѿ��ɹ���¼ϵͳ");
				return ADMIN_RESULT;
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
