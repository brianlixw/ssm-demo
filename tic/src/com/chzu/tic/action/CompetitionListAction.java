package com.chzu.tic.action;

import com.chzu.tic.util.PageBean;

//���������У����ͨ����δͨ�����ܴ�����
public class CompetitionListAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	private int page; // �ڼ�ҳ
	private PageBean pageBean; // ������ҳ��Ϣ��bean

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
	
	/**
	 * ���������ͨ������
	 * @return
	 * @throws Exception
	 */
	public String pass()throws Exception{
		// ��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
		this.pageBean = teacherService.queryPassOrNoPassForPage(5, page,true);
		return SUCCESS;
	}
	
	/**
	 * �������δͨ������
	 * @return
	 * @throws Exception
	 */
	public String nopass()throws Exception{
		// ��ҳ��pageBean,����pageSize��ʾÿҳ��ʾ��¼��,pageΪ��ǰҳ
		this.pageBean = teacherService.queryPassOrNoPassForPage(5, page,false);
		return SUCCESS;
	}

}
