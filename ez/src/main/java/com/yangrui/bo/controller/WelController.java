package com.yangrui.bo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yangrui.bo.dao.StudentDao;
import com.yangrui.bo.entity.Student;

@Controller
public class WelController {

	@Autowired
	private StudentDao studentDao;
	
	@ResponseBody
	@GetMapping("wel")
	public List reward() {
		System.out.println("xxxx");
		List<Student> students=studentDao.findAll();
		for (Student student : students) {
			System.out.println(student.getName());
		}
		return students;
	}
	
	@GetMapping("list")
	public ModelAndView list() {
		System.out.println("list界面");
		return new ModelAndView("list");
	}
}
