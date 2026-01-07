package com.chetan.SpringMvcCrud.service;

import java.util.List;

import com.chetan.SpringMvcCrud.model.Student;

public interface StudentServiceI {
	
	public boolean saveStudent(Student stu);
	
	public List<Student> getAllStudent();
	
	public boolean updateStudent (Student stu);
	
	public boolean deleteStudent(int sId);
	
	public boolean deleteAllStudent();

}
