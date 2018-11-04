package com.yangrui.sanguo.dao;

import java.util.List;

import com.yangrui.sanguo.entity.Student;

public interface StudentDao {

	/**
	 * 查询所有数据
	 * */
	public List<Student> queryAll();
}
