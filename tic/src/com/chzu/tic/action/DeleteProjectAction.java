package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;

/**
 * ��Action����ɾ��������Ŀ
 */
public class DeleteProjectAction extends TeacherBaseAction {
	private static final long serialVersionUID = 1L;

	public String execute()throws Exception{
		String idString=ServletActionContext.getRequest().getParameter("project.id");
		Integer id = Integer.parseInt(idString);
		teacherService.deleteProject(id);
		return SUCCESS;
	}

}
