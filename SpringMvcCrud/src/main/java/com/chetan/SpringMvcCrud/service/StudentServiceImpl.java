package com.chetan.SpringMvcCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetan.SpringMvcCrud.model.Student;
import com.chetan.SpringMvcCrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean saveStudent(Student stu) {
		Student save = studentRepository.save(stu);
		if (save != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> allStudent = (List<Student>) studentRepository.findAll();
		return allStudent;
	}

	@Override
	public boolean updateStudent(Student stu) {
		Student student = studentRepository.save(stu);
		if (student != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int sId) {
		boolean existsById = studentRepository.existsById(sId);
		if (existsById) {
			studentRepository.deleteById(sId);
			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean deleteAllStudent() {

		List<Student> all = (List<Student>) studentRepository.findAll();
		System.out.println(all);
		if (all != null) {
			studentRepository.deleteAll();
			return true;
		} else {
			return false;
		}
	}

}
