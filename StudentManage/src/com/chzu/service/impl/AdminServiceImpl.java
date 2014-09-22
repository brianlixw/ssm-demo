package com.chzu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chzu.model.Admin;
import com.chzu.model.ClassGrade;
import com.chzu.model.Student;
import com.chzu.service.AdminService;
import com.chzu.util.PageBean;

public class AdminServiceImpl extends BaseService implements AdminService {

	/**
	 * ����0��½�ɹ�������-1��½ʧ��
	 */
	@Override
	public int validLogin(Admin admin) {
		if (adminDao.findByNameAndPass(admin).size() > 0) {
			return 0;
		}
		return -1;
	}
	
	/**
	 * �ɹ�����student���󣬷��򷵻�null
	 */
	@Override
	public Student validLogin(Student student) {
		if(studentDao.findByNameAndPass(student).size()>0){
			return studentDao.findByNameAndPass(student).get(0);
		}
		
		return null;
	}

	@Override
	public PageBean queryUserForPage(int pageSize, int page) {
		final String hql = "from Student"; // ��ѯ���
		int allRow = studentDao.getAllRowCount(hql); // �ܼ�¼��
		int totalPage = PageBean.countTotalPage(pageSize, allRow); // ��ҳ��
		final int offset = PageBean.countOffset(pageSize, page); // ��ǰҳ��ʼ��¼
		final int length = pageSize; // ÿҳ��¼��
		final int currentPage = PageBean.countCurrentPage(page);
		List<Student> list = studentDao.findByPage(hql, offset, length); // "һҳ"�ļ�¼

		// �ѷ�ҳ��Ϣ���浽Bean��
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	@Override
	public Boolean exit(String number) {
	    Student listFile =studentDao.findByName(number);
		if (listFile!=null) {// ��ͬ�û��Ѵ���
			return true;
		}
		return false;
	}

	@Override
	public Student findByName(String name) {
		return studentDao.findByName(name);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentDao.delete(id);

	}

	@Override
	public void updateStudent(Student user) {
		studentDao.update(user);

	}

	@Override
	public void addStudent(Student user) {
		studentDao.save(user);

	}

	@Override
	public Student findStudent(Integer id) {
		return studentDao.get(id);
	}

	/**
	 * 
	 * @param mobile
	 *            �ֻ���
	 * @return �ֻ��Ÿ�ʽ��ȷ����true�����󷵻�false
	 */
	public Boolean isMobile(String mobile) {
		// ^ ��ƥ������Ŀ�ʼλ��
		// \������һ���ַ����Ϊ�����ַ�������ֵ
		// * ��ƥ��ǰһ���ַ���λ򼸴�
		// + ��ƥ��ǰһ���ַ�һ�λ���
		// (pattern) ��ģʽƥ�䲢��סƥ��
		// \w �����κε����ַ�ƥ�䣬�����»���
		// {n,m} ����ƥ�� n �������ƥ�� m ��
		// [a-z] ����ʾĳ����Χ�ڵ��ַ�����ָ�������ڵ��κ��ַ�ƥ��
		// ?��ƥ��ǰ����ӱ��ʽ��λ�һ��
		// $ ��ƥ������Ľ�β
		String regex = "^((\\+86)|(86))?\\d{11}$";// ƥ���ֻ���ǰ��86����+86�����
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}


	@Override
	public void updateStudent(String number, String username, String sex,
			Date birthday, String phone, Integer id) {
		studentDao.update("update Student t set t.number='"
				+ number + "',t.username = '"
				+ username + "',t.sex='" + sex
				+ "',t.birthday='" + birthday + "',t.phone='"
				+ phone + "'" + " where id ='" + id
				+ "'");
		
	}

	@Override
	public List<ClassGrade> findAllClassGrade() {
		return classGradeDao.findAll();
	}

	@Override
	public ClassGrade findById(Integer id ) {
	   return classGradeDao.get(id);
	}

	@Override
	public ClassGrade findClassGradeByName(String name) {
		return classGradeDao.findByName(name);
	}

	@Override
	public List<Student> getStudentList(Integer clasid) {
		List<Student> students=new ArrayList<Student>();
		//��ȡָ���İ༶
		ClassGrade classGrade=classGradeDao.get(clasid);
		//���ݰ༶��students���Եõ�����������ѧ��
		Set<Student> classGrades=classGrade.getStudents();
		for (Student student : classGrades) {//����set���ϰ�ѧ���ŵ�list������
			students.add(student);
		}
		return students;
	}


}
