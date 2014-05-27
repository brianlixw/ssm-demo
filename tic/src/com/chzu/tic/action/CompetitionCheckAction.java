package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.User;

//��Action��׼��ȡ��ѧ���μӱ���
public class CompetitionCheckAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		String idString = ServletActionContext.getRequest().getParameter(
				"user.id");
		String check = ServletActionContext.getRequest().getParameter("check");
		Integer id = Integer.parseInt(idString);
		User user = new User();
		user=teacherService.getUser(id);
		user.setId(id);
		user.setUsername(user.getUsername());
		user.setPassword(user.getPassword());
		user.setEmail(user.getEmail());
		user.setType(user.getType());
		user.setTeam(user.getTeam());
		System.out.println("checkd==============================================================="+check);
		if (check.equals("0")) {// ��׼ѧ�������ʸ񣬰����ݿ����ֶ�δͨ����Ϊ��ͨ��
			user.setState("��ͨ��");
			teacherService.updateApprove(user);
		} else if (check.equals("1")) {// ȡ��ѧ�������ʸ񣬰����ݿ����ֶ���ͨ����Ϊδͨ��
			user.setState("δͨ��");
			teacherService.updateApprove(user);
		}
		return SUCCESS;
	}

}
