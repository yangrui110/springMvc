package com.yangrui.sanguo.exception;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaseException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		String accept=request.getHeader("accept");
		if(accept.contains("text/html")) System.out.println("是网页请求");
		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration=request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			System.out.println(string+"---"+request.getHeader(string));
		}
		ExceptionEntity entity=new ExceptionEntity();
		String path=request.getRequestURI();
		entity.setPath(path);
		entity.setCode(500);
		entity.setMsg("出错啦");
		JSON object=(JSON) JSONObject.toJSON(entity);
		String result=object.toJSONString();
		response.setCharacterEncoding("utf-8");
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(result);
			return new ModelAndView();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("error");
	}

}
