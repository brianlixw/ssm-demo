package com.chzu.tic.action;

import com.chzu.tic.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// ������ҵ���߼����
	protected TeacherService teacherService;

	// ��������ע���set�����������Զ�װ����ԣ�set��������AdminServiceƥ��spring��bean��idֵ
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

}
