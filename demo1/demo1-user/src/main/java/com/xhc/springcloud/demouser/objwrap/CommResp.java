package com.xhc.springcloud.demouser.objwrap;

import com.xhc.springcloud.demouser.constants.ResponseConstants;

public class CommResp<T> {

	private String code;

	private String msg;

	private T data;


	public CommResp() {
	}

	public CommResp(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public CommResp<T> makeSuccessResp(){
		this.code = ResponseConstants.SUCCESS_CODE;
		this.msg = ResponseConstants.SUCCESS_MSG;
		return this;
	}

	public CommResp<T> makeFailResp(){
		this.code = ResponseConstants.FAIL_CODE;
		this.msg = ResponseConstants.FAIL_MSG;
		return this;
	}


	/** getter setter **/

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
