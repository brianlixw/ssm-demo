package com.chzu.action.android;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * ����ѧ����Ϣ������android�ͻ��˴�����json��ʽ������ ֻ�޸��û������Ա𣬳������ڣ��ֻ���
 */
public class UpdateStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	// �Ϳͻ��˶�Ӧ��Ӧ�����ԣ�struts���Զ����ո�ֵ
	private String number;// ѧ��
	private String username;
	private String sex;
	private Date birthday;
	private String phone;
	private String updateResult;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	// �Խ��յ���ʱ���ʽ��
	@JSON(format = "yyyy-MM-dd")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	/**
	 * ����android�ͻ��˷�����json���� �������Ա𣬳������ڣ��ֻ���
	 */
	public String execute() throws Exception {
		Student student = adminService.findByName(getNumber());
		if (student != null) {
			student.setUsername(getUsername());
			student.setSex(getSex());
			student.setBirthday(getBirthday());
			student.setPhone(getPhone());
			adminService.updateStudent(student);
			setUpdateResult("success");// ���ظ�android�ͻ���
		}
		return SUCCESS;
	}

}
