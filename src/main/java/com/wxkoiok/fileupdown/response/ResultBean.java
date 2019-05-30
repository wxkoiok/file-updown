package com.wxkoiok.fileupdown.response;

import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 * 
 * @author wuyin
 *
 * @param <T>
 */
@Data
public class ResultBean<T> {

	private String msg;

	private int code;

	private T data;
	
	private boolean success;

	public ResultBean(T data) {
		this(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value(), data,true);
	}
	
	public ResultBean() {
	}
	public ResultBean(String msg, int code, T data, boolean success) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
		this.success=success;
	}


}
