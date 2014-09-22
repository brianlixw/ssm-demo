package com.chzu.action;

import com.chzu.util.PageBean;

public class StudentListAction extends AdminBaseAction {

	private static final long serialVersionUID = 1L;

	private int page; // �ڼ�ҳ
	private PageBean pageBean; // �����ֲ���Ϣ��bean

	public int getPage() {
		return page;
	}

	public void setPage(int page) { // ��URL���޴˲���,��Ĭ��Ϊ��1ҳ
		this.page = page;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public String execute() throws Exception {
		// ��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
		this.pageBean = adminService.queryUserForPage(5, page);
		return SUCCESS;
	}
}
