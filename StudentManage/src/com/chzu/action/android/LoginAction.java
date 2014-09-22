package com.chzu.action.android;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * android��¼��֤
 * 
 * @author Administrator
 *
 */
public class LoginAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private String loginResult;// ���ص�¼��־�ɹ���־
	// ����android�ͻ��˷������û���������student.username,student.password
	// ������ַ�����û�з�װ��json��ʽ������
	private Student student;

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String execute() throws Exception {
		student = adminService.validLogin(student);
		if (student != null) {
			setLoginResult("success");
		}
		return SUCCESS;
	}
}
