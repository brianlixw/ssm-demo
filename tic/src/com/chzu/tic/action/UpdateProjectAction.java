package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;
import com.chzu.tic.model.Project;

/**
 * 
 * ���±�����Ŀ��Ϣ
 */
public class UpdateProjectAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	private Project project;//��װupdate.jspҳ���ύ������
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String execute()throws Exception{
		String idString=ServletActionContext.getRequest().getParameter("project.id");
		Integer id=Integer.valueOf(idString);
		project.setId(id);
		project.setName(project.getName());
		project.setLevel(project.getLevel());
		project.setPeriod(project.getPeriod());
		teacherService.updateProject(project);
		return SUCCESS;
	}
	
}
