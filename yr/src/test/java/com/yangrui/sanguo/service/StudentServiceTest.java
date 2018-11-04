package com.yangrui.sanguo.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yangrui.sanguo.BaseTest;
import com.yangrui.sanguo.entity.Student;

public class StudentServiceTest extends BaseTest{

	@Autowired
	private StudentService studentService;
	
	@Test
	public void test() {
		List<Student> list=studentService.query();
		
	}
}
