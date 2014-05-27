package com.chzu.tic.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.File;

public class DownloadAction extends TeacherBaseAction {
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String filePath;// Ҫ���ص��ļ�·��

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 
	 * ����һ������InputStream�ķ������÷�������Ϊ�������ļ������
	 * ����Ҫ����stream���ͽ��ʱָ��inputName����(struts���������Ե�����),
	 * inputName������ֵ���Ƿ���ȥ��getǰ׺������ĸСд���ַ���
	 */
	public InputStream getTargetFile() throws Exception {
		String idString=ServletActionContext.getRequest().getParameter("file.id");
		Integer id = Integer.parseInt(idString);
		File file = teacherService.getFile(id);
		setFileName(file.getName());// Ϊ���ص��ļ�������
		setFilePath(file.getPath());// �����ļ�·��ָ�����ݿ����ļ���·��
		return new java.io.FileInputStream(getFilePath());
	}

	public String execute() throws Exception {
		return SUCCESS;

	}

}
