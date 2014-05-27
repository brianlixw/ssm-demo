package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.File;

public class DeleteFileAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	
	public String execute()throws Exception{
		String idString=ServletActionContext.getRequest().getParameter("file.id");
		Integer id = Integer.parseInt(idString);
		File file = teacherService.getFile(id);
		deleteDiskFile(file.getPath());//��ɾ�����̼�¼
		teacherService.deleteFile(id);//��ɾ�����ݿ��м�¼
		return SUCCESS;
	}
	
   //ɾ���������ļ�
	public Boolean deleteDiskFile(String filePath){
		java.io.File file = new java.io.File(filePath);     
        if(file.exists()){     
            if(file.delete()){
            	return true;
            }
            else {
				return false;
			}
        }
           return true;
	}
}
