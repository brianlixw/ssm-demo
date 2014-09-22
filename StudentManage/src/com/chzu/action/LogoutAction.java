package com.chzu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	// ����һ��HttpServletRequest����
	private HttpServletRequest request;

	// ʵ��ServletRequestAware�ӿڱ�����д�ķ���
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		// ��ȡHttpSession
		HttpSession session = request.getSession();
		// ʹSessionʧЧ
		session.invalidate();
		return SUCCESS;
	}
}
