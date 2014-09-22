package com.chzu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chzu.model.ClassGrade;
import com.chzu.model.Student;

/**
 * ��action����Ϊ��¼������֤��jsp����ʾ������Ա ��½�ɹ���������ʾ
 * 
 * @author Administrator
 *
 */
public class BackShowAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private List<String> list = new ArrayList<String>();
	private List<ClassGrade> list1 = new ArrayList<ClassGrade>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	/**
	 * ���ؿ�ܲ���top.jspҳ��
	 */
	public String top() throws Exception {
		return "top";
	}

	/**
	 * ���ؿ�ܲ�����ߵ�left.jspҳ��
	 */
	public String left() throws Exception {
		return "left";
	}

	/**
	 */
	public String verifycode() throws Exception {
		return "verifycode";
	}

	/**
	 * ���ؿ�ܲ����ұߵ�main.jspҳ��
	 */
	public String main() throws Exception {
		return "main";
	}

	/**
	 * ��������ѧ��search.jspҳ��
	 */
	public String search() throws Exception {
		return "search";
	}

	/**
	 * �����޸�ѧ��update.jspҳ��, �������޸�ѧ����update.jspҳ��
	 */
	public String update() throws Exception {
		String id = ServletActionContext.getRequest().getParameter("user.id");
		list.add(id);
		Student user = new Student();
		user = adminService.findStudent(Integer.valueOf(id));
		list.add(user.getNumber());
		list.add(user.getUsername());
		list.add(user.getSex());
		if (user.getBirthday() != null) {
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
			String birthday = fm.format(user.getBirthday());
			list.add(birthday);
		} else {
			list.add("");
		}
		list.add(user.getPhone());
		list.add(user.getClassGrade().getName());// �༶
		list.add(user.getClassGrade().getPro().getName());// רҵ
		list.add(user.getClassGrade().getPro().getDep().getName());// Ժϵ
		list1 = adminService.findAllClassGrade();
		return "update";
	}

	/**
	 * �������ѧ��add.jspҳ��
	 */
	public String add() throws Exception {
		list1 = adminService.findAllClassGrade();
		for (ClassGrade string : list1) {
			System.out.println(string.getName());
		}
		return "add";
	}

	public List<ClassGrade> getList1() {
		return list1;
	}

	public void setList1(List<ClassGrade> list1) {
		this.list1 = list1;
	}

}
