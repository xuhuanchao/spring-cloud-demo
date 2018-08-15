package com.xhc.springcloud.demouser.controller;

import com.xhc.springcloud.demouser.constants.ResponseConstants;
import com.xhc.springcloud.demouser.objwrap.CommResp;
import com.xhc.springcloud.demouser.objwrap.vo.UserParam;
import com.xhc.springcloud.demouser.objwrap.vo.UserVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public CommResp<UserVo> addUser(@RequestBody @Valid UserParam userParam, BindingResult bindingResult){
		CommResp<UserVo> result = new CommResp<>();
		if(bindingResult.hasErrors()){
			for(ObjectError error : bindingResult.getAllErrors()){
				result.setCode(ResponseConstants.PARAM_ILLEGAL_CODE);
				result.setMsg(error.getDefaultMessage());
				break;
			}
		}else{
			result.makeSuccessResp();
		}
		return result;
	}
}
