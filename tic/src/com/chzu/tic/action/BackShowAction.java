package com.chzu.tic.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

/**
 * ��action����Ϊ��¼������֤��jsp����ʾ������Ա����ʦ
 * ��½�ɹ���������ʾ
 * @author Administrator
 *
 */
public class BackShowAction extends TeacherBaseAction{

	private static final long serialVersionUID = 1L;
	private List<String> list=new ArrayList<String>();
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	/**
	 * ���ؿ�ܲ���top.jspҳ��
	 */
	public String top() throws Exception {
		return "top";
	}
   
	/**
	 * ���ؿ�ܲ�����ߵ�left.jspҳ��
	 */
	public String left() throws Exception {
		return "left";
	}
	
    /**
     * ���ؿ�ܲ��ֵײ���buttom.jspҳ��
     */
	public String buttom() throws Exception {
		return "buttom";
	}
    
	/**
	 * ���ص�¼�������֤��verifycode.jspҳ��
	 */
	public String verifycode() throws Exception {
		return "verifycode";
	}
	
	/**
	 * ���ؿ�ܲ����ұߵ�main.jspҳ��
	 */
	public String main() throws Exception {
		return "main";
	}
	
	/**
	 *��ת���ϴ��ļ����� 
	 */
	public String upload() throws Exception {
		return "upload";
	}
	
	/**
	 * ��������������Ŀsearch.jspҳ��
	 */
	public String search() throws Exception{
		return "search";
	}
	
	/**
	 * �����޸ı�����Ŀupdate.jspҳ��,
	 * ������Ҫ�޸���Ŀ��Ϣ��update.jspҳ��
	 */
	public String update() throws Exception{
		String id=ServletActionContext.getRequest().getParameter("project.id");
		//��ȡҳ�洫������ֵ
		String nameString=ServletActionContext.getRequest().getParameter("project.name");
		String levelString=ServletActionContext.getRequest().getParameter("project.level");
		String periodString=ServletActionContext.getRequest().getParameter("project.period");
		//�������ַ����д���
		String  name=new  String(nameString.getBytes("iso8859-1"),"utf-8");
		String level=new String(levelString.getBytes("iso8859-1"),"utf-8");
		String period=new String(periodString.getBytes("iso8859-1"),"utf-8");
		list.add(id);
		list.add(name);
		list.add(level);
		list.add(period);
		return "update";
	}
	
	/**
	 * ������ӱ�����Ŀadd.jspҳ��
	 */
	public String add()throws Exception{
		return "add";
	}
	
	/**
	 * ����û�����addUser.jspҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		return "addUser";
	}
}
