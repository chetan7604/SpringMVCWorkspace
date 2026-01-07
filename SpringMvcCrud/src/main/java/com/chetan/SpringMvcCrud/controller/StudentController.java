package com.chetan.SpringMvcCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chetan.SpringMvcCrud.model.Student;
import com.chetan.SpringMvcCrud.service.StudentServiceI;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;

	@GetMapping("/welcomestudent")
	public String loadForm() {
		return "WelcomeStudent";
	}

	@GetMapping("/saveStudent")
	public ModelAndView saveStudent(Student stu) {
		boolean saveStudent = studentServiceI.saveStudent(stu);
		if (saveStudent) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("STUSUCC", "Student saved successfully");
			mav.setViewName("regsucc");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("STUFAIL", "Student Not Saved.");
			mav.setViewName("regfail");
			return mav;
		}

	}

	@GetMapping("/getallstudent")
	public String getAllStudent(Model model) {
		List<Student> allStudent = studentServiceI.getAllStudent();
		model.addAttribute("ALLSTUDENT", allStudent);
		return "getAllStu";
	}

	@GetMapping("/updateStudent")
	public ModelAndView updateStudent(Student stu) {
		boolean updateStudent = studentServiceI.updateStudent(stu);

		if (updateStudent) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("UPDATESUCC", "Student update successfully");
			mav.setViewName("updatesucc");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("UPDATEFAIL", "Student Not updated.");
			mav.setViewName("updatefail");
			return mav;
		}
	}

	@GetMapping("/deleteStudent")
	public ModelAndView deleteStudent(int sId) {
		System.out.println(sId);

		boolean deleteStudent = studentServiceI.deleteStudent(sId);
		if (deleteStudent) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("DELETESUCC", "Student delete successfully");
			mav.setViewName("deletesucc");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("DELETEFAIL", "Student Not deleted.");
			mav.setViewName("deletefail");
			return mav;
		}

	}
	
	
	@GetMapping("/deleteAllStudent")
	public ModelAndView deleteAllStudent() {
		boolean deleteAllStudent = studentServiceI.deleteAllStudent();
		System.out.println(deleteAllStudent);
		if (deleteAllStudent) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("DELETEALLSUCC", "All Student delete successfully");
			mav.setViewName("deleteallsucc");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("DELETEALLFAIL", "All Student Not deleted.");
			mav.setViewName("deleteallfail");
			return mav;
		}
	}

}
