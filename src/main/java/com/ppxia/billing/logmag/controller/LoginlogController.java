package com.ppxia.billing.logmag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ppxia.billing.beans.PagerBean;

@Controller
@RequestMapping("/loginlog")
public class LoginlogController {

	/**
	 * 分页
	 */
	@ResponseBody
	@RequestMapping(value="/find",method= {RequestMethod.POST},produces= {"application/json;charset=utf-8"})
	public PagerBean findManger() {
		return null;
	}

}
