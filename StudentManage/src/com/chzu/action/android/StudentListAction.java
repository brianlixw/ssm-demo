package com.chzu.action.android;

import java.util.ArrayList;
import java.util.List;

import com.chzu.action.AdminBaseAction;
import com.chzu.model.Student;

/**
 * 
 * ��ȡָ��ѧ����ͬ��ͬѧ�б�
 * 
 */
public class StudentListAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;
	private Student student;// ����android�ͻ��˴�����student.number�ַ���
	private List<Student> students = new ArrayList<Student>();

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String execute() throws Exception {
		Student student1 = adminService.findByName(student.getNumber());
		Integer id = student1.getClassGrade().getId();// ��ȡ�༶id
		students = adminService.getStudentList(id);
		return SUCCESS;
	}

}
