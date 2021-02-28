package com.suyh.test01.beans.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ComponentBean02 {
	public ComponentBean02() {
		log.info("construct ComponentBean02");
	}

	/**
	 * 在构造方法之后被调用
	 */
	@PostConstruct
	public void postConstruct() {
		log.info("ComponentBean02 postConstruct");
	}
}
