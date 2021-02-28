package com.suyh.test01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestDemoController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
