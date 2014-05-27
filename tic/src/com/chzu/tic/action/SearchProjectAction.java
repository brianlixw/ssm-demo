package com.chzu.tic.action;

import java.util.List;

import com.chzu.tic.model.Project;

public class SearchProjectAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	private String tip;//����ʧ����ʾ
	private Project project;//����JSPҳ�洫������project.nameֵ(struts��װ)
	private List<Project> listProject;//get.set��������JSPҳ�����listProject
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getListProject() {
		return listProject;
	}

	public void setListProject(List<Project> listProject) {
		this.listProject = listProject;
	}

	public String execute()throws Exception{
		this.listProject=teacherService.findProjectByName(project.getName());
		if (listProject.size()<=0) {
			setTip("�������ı�����Ŀ�����ڣ���˶Ժñ�����Ŀ�������ԣ�");
            return INPUT;
		}
		return SUCCESS;
	}

}
