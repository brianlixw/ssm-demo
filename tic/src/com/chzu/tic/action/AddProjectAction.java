package com.chzu.tic.action;

import com.chzu.tic.model.Project;
/**
 * 
 * ��ӱ�����Ŀ
 */
public class AddProjectAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;//
	private Project project;//��װadd.jspҳ���ύ������
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String execute()throws Exception{
		project.setName(project.getName());
		project.setLevel(project.getLevel());
		project.setPeriod(project.getPeriod());
		teacherService.addProject(project);
		return SUCCESS;
	}
}
