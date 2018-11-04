package com.yangrui.sanguo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangrui.sanguo.exception.CommonException;
import com.yangrui.sanguo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value="list")
	@ResponseBody
	public Map<String, Object> query(){
		logger.info("测试信息");
		Map<String, Object> map=new HashMap<>();
		map.put("data", studentService.query());
		logger.debug("测试调试输出信息");
		logger.error("错误输出信息");
		throw new CommonException(200, "出错");
		//return map;
	}
}