package com.xhc.springcloud.demouser.objwrap.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserParam {

	@NotNull(message = "userId不能为空")
	private Long userId;

	@NotEmpty(message = "用户姓名不能为空")
	private String userName;

	@NotEmpty(message = "登录名不能为空")
	private String loginName;

	@NotNull(message = "性别不能为空")
	private Integer sex;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
