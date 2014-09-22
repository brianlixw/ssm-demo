package com.chzu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Professional implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;// ��ʶ����
	private String name;// רҵ����
	private Department dep;//רҵ����Ժϵ
	private Set<ClassGrade> classGrades = new HashSet<ClassGrade>();
	
	public Professional() {
	}

	public Professional(Integer id, String name, Department dep,
			Set<ClassGrade> course) {
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.classGrades = course;
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

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public Set<ClassGrade> getClassGrades() {
		return classGrades;
	}

	public void setClassGrades(Set<ClassGrade> classGrades) {
		this.classGrades = classGrades;
	}

	
	
	
	
	
}