package com.chzu.action.android;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * ����ѧ�����룬����android�ͻ��˴�����ѧ�ź������ַ���
 */
public class UpdatePasswordAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	// �Ϳͻ��˶�Ӧ��Ӧ�����ԣ�struts���Զ����ո�ֵ
	private Student student;// ��ȡ�ͻ����ύ��student.number��student.password
	private String updateResult;

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String execute() throws Exception {
		Student student1 = adminService.findByName(student.getNumber());
		if (student1 != null) {
			student1.setPassword(student.getPassword());
			adminService.updateStudent(student1);
			setUpdateResult("�޸ĳɹ�!");// ���ظ�android�ͻ���
		}
		return SUCCESS;
	}

}
