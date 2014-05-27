package com.chzu.tic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UploadAction extends TeacherBaseAction{

	private static final long serialVersionUID = 1L;
	private File content;// �ļ�����
	// ��װ�ϴ��ļ�content����������(ContentType)���ļ�������(FileName)
	private String contentContentType;
	private String contentFileName;
	private String savePath;// �ϴ��ļ��ı���·������struts.xml�������·��
	// �����¼�����ʾ��Ϣ
    private String tip;
    com.chzu.tic.model.File ticFile=new com.chzu.tic.model.File();
	public File getContent() {
		return content;
	}

	public void setContent(File content) {
		this.content = content;
	}

	public String getContentContentType() {
		return contentContentType;
	}

	public void setContentContentType(String contentContentType) {
		this.contentContentType = contentContentType;
	}

	public String getContentFileName() {
		return contentFileName;
	}

	public void setContentFileName(String contentFileName) {
		this.contentFileName = contentFileName;
	}

	/**
	 * @return �ϴ��ļ�����d��uploadĿ¼�� ����struts.xml�����ļ�savePath��ֵ
	 */
	public String getSavePath() {
		String directory = "D:"+"\\"+savePath;
		File file=new File("D:\\upload");
		  if (!(file.exists())&&!(file.isDirectory())) {//���upload�ļ��в�����
            file.mkdirs();//����upload�ļ���
	}
		return directory;
	}

	/**
	 * ����struts.xml�����ļ��б����ļ������·��
	 * 
	 * @param savePath
	 *            struts.xml�����õı����ļ�·��savePath��ֵ
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
		
	} 
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * 
	 * ��֤�û��ϴ����ļ��Ƿ����
	 */
	public Boolean exit(){
		if(teacherService.exit(getContentFileName())){//�ļ��Ѵ���
			setTip("��ͬ�ļ����Ѵ��ڣ�");
			return true;
		}
		else {
			return false;
		}
	}
	 
	public String execute() throws Exception {
		if(exit()){
			return "input";
		}
		// ���ϴ����ļ�д�뵽upload�ļ�����
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ getContentFileName());
		FileInputStream fis = new FileInputStream(getContent());
		byte[] butter = new byte[1024];
		int len = 0;
		while ((len = fis.read(butter)) > 0) {
			fos.write(butter, 0, len);
		}
		fos.close();
		fis.close();
		ticFile.setName(getContentFileName());
		ticFile.setPath(getSavePath()+"\\"+getContentFileName());
		teacherService.upload(ticFile);
		return "success";
	}
	
	/**
	 * �ļ���С����struts.xmlȫ���ϴ����ļ���С��
	 * ���Բ���maximumSizeע��ʧ�ܣ�����upload.jsp������ʾ�ϴ����ļ����Ϊ40M��ʾ
	 * ��дaddActionError����Ŀ�Ľ��struts.xml�����ò���maximumSize����ע��ʧ��
	 * ���⣬��jspҳ����ظ���ʾ���δ�����Ϣ��ԭ��������fileUpload��������������Ĭ��������
	 * ����Ĭ�����������յ��ļ��Ľ�Ϊnull
	 * @param anErrorMessage
	 *            ����ļ���С����struts.xmlȫ���ϴ����ļ���С������Ϣ
	 */
	@Override
	public void addActionError(String anErrorMessage) {
			//�ӹ��ʻ���ȡֵ,������˵�ļ�����(����ȫ���ļ��ϴ���С)������Ϣ��
		    //��the request was rejected because its size��ͷ
		    //��������Request exceeded allowed size limit��ͷ
			if (anErrorMessage
					.startsWith("Request exceeded allowed size limi")) {
				super.addActionError(getText("struts.multipart.maxSize.limit"));
			} else {
				super.addActionError(anErrorMessage);
			}
	}

}
