package com.chzu.service;


import java.util.Date;
import java.util.List;

import com.chzu.model.Admin;
import com.chzu.model.ClassGrade;
import com.chzu.model.Student;
import com.chzu.util.PageBean;

public interface AdminService {
	
	int validLogin(Admin admin);//����Ա��֤��¼
	
	public Student validLogin(Student student);//ѧ����֤��¼
	
	/**
 	 * ��֤��ӵ�ѧ���Ƿ��Ѿ�����
 	 */
	public Boolean exit(String number);
	
    /**
	 * ����ѧ�Ų�ѯѧ��
	 */
    public Student findByName(String number);
    
    /**
     * ����id��ѯѧ��
     */
    public Student findStudent(Integer id);
    
    
    
    /**
     * ����idɾ��ѧ��
     */
    public void deleteStudent( Integer id);
    
    /**
     * ����ѧ��ȫ����Ϣ
     */
    public void updateStudent(Student student);
    
    /**
     *
     * ����ѧ����Ϣ
     * @param number ѧ��
     * @param username  ����
     * @param sex �Ա�
     * @param birthday ��������
     * @param phone �ֻ���
     * @param id ָ��Ҫ����ѧ����id
     */
    public void updateStudent(String number,String username,String sex,Date birthday,String phone,Integer id);
    
    
    /**
     * ���ѧ��
     * 
     */
    public void addStudent(Student user);
    
    /**
     * ѧ����ҳ��ѯ
     * @param pageSize ÿҳ��С
     * @param page ��ǰ�ڼ�ҳ
     * @return ��װ�˷�ҳ��Ϣ(������¼��list)��Bean
     */
    public PageBean queryUserForPage(int pageSize,int currentPage);
    
    public Boolean isMobile(String mobile);
    
    /**
     * ��ȡ���а༶
     * @return
     */
    public List<ClassGrade> findAllClassGrade();
    
    /**
     * ����id��ȡ�༶
     * @return
     */
    public ClassGrade findById(Integer id);
    
    /**
     * �������ƻ�ȡ�༶
     */
    public ClassGrade findClassGradeByName(String name);	
    
    /**
     * ��ȡͬһ�����ѧ��
     * @param clasid �༶id
     * @return
     */
    public List<Student> getStudentList(Integer clasid);
    
    	
}
