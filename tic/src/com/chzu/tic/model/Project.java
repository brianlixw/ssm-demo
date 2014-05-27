package com.chzu.tic.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// ��־����
	private String name;// ��Ŀ����
	private String level;// ��Ŀ����
	private String period;//��������
	private String remark;//��ע��Ϣ
	//1-N������ϵ����Set�������ʵ��
	//����һ�Զ��ѯʱ����װ��ѯ�õ�������User����
	private Set<User> users=new HashSet<User>();
 	public Project() {
	}

	public Project(Integer id, String name, String level, String period,String remark,
			Set<User> users) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.period = period;
		this.remark=remark;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
