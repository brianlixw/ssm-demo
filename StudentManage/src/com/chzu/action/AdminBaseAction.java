package com.chzu.action;

import com.chzu.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminBaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// ������ҵ���߼����
	protected AdminService adminService;

	// ��������ע���set�����������Զ�װ����ԣ�set��������AdminServiceƥ��spring��bean��idֵ
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
