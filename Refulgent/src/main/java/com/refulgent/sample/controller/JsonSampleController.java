package com.refulgent.sample.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.refulgent.entity.UserAccount;
import com.refulgent.sample.model.UserAccountBean;
import com.refulgent.sample.service.UserAccountService;


@Controller
public class JsonSampleController {
	
	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping(value = "/jsonSample", method = RequestMethod.POST)
	@ResponseBody
	public void jsonSampleMethod(@RequestParam("userName") String userName) {
		UserAccountBean userAccountBean = new UserAccountBean();
		UserAccount userAccount = new UserAccount();
		userAccountBean.setUserName("Karthick");
		userAccountBean.setPassword("password");
		String encrypedPassword = BCrypt.hashpw(userAccountBean.getPassword(),  BCrypt.gensalt(12));
		userAccountBean.setPassword(encrypedPassword);
		BeanUtils.copyProperties(userAccountBean, userAccount);
		userAccountService.save(userAccount);
	}
}
