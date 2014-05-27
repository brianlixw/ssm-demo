package com.chzu.tic.model;

import java.io.Serializable;

public class User implements Serializable {
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", typename=" + typename
				+ ", email=" + email + "]";
	}

	private static final long serialVersionUID = 1L;
	private Integer id;// ��ʶ����
	private String username;// �û���
	private String password;// ����
	private Integer type;// �û�����
	private String team;//����
	private String email;// ����
	private String typename;
	private String state;//����״̬
	private Project project;
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	private String repassword;//����ȷ�� ��hj�޸�
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public User() {
	}

	public User(Integer id, String username, String password, Integer type,String team,
			String email,String typename,String state,Project project) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.team=team;
		this.email = email;
		this.typename=typename;
		this.state=state;
		this.project=project;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	// ��дequals()������name,pass��ͬ��Ϊͬһ�û�
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == User.class) {
			User user = (User) obj;
			return this.getUsername().equals(user.getUsername())
					&& this.getPassword().equals(user.getPassword());
		}
		return false;
	}

}
