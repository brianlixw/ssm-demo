package com.chzu.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.ClassGrade;
import com.chzu.model.Student;

/**
 * ���ѧ��
 */
public class AddStudentAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private Student student;// ��װadd.jspҳ���ύ������

	private String tip;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		String name = ServletActionContext.getRequest().getParameter("name");
		ClassGrade classGrade = adminService.findClassGradeByName(name);
		student.setClassGrade(classGrade);
		student.setPassword("000000");

		String birthday = ServletActionContext.getRequest().getParameter(
				"birthday");
		if (adminService.exit(student.getNumber().trim())) {
			setTip("��ѧ�ŵ�ѧ���Ѿ����ڣ�");
			return "input";
		}
		if (birthday.contains("/")) {
			StringBuffer sb = new StringBuffer();
			String s[] = birthday.split("/");
			sb.append(s[2] + "-");
			sb.append(s[0] + "-");
			sb.append(s[1]);
			birthday = sb.toString();
		}
		if (!birthday.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = birthday;
			Date date = sdf.parse(strDate);
			student.setBirthday(date);
		}
		student.setNumber(student.getNumber().trim());// ȥ���ո�
		adminService.addStudent(student);
		return SUCCESS;
	}
}
