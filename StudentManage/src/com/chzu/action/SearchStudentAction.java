package com.chzu.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.Student;

public class SearchStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private String tip;// ����ʧ����ʾ
	private Student user;// ����JSPҳ�洫������project.numberֵ(struts��װ)

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Student getUser() {
		return user;
	}

	public void setUser(Student user) {
		this.user = user;
	}

	public String execute() throws Exception {
		String number = ServletActionContext.getRequest()
				.getParameter("number");
		// �������ַ����д���
		String title = new String(number.getBytes("iso8859-1"), "utf-8");
		user = adminService.findByName(title);
		if (user == null) {
			setTip("��������ѧ�������ڣ���˶����ԣ�");
			return INPUT;
		}
		return SUCCESS;
	}

}
