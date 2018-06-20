package com.ppxia.billing.authortymag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/jump")
	public String jump(String viewName) {
		System.out.println(999);
		return "/static/index22.ftl";
	}
}
