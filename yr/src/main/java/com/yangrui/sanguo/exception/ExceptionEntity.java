package com.yangrui.sanguo.exception;

import lombok.Data;

@Data
public class ExceptionEntity {

	private int code;
	private String msg;
	private String path;
	
}
