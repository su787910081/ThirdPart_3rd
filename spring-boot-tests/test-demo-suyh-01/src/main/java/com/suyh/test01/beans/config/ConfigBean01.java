package com.suyh.test01.beans.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
@Slf4j
public class ConfigBean01 implements InitializingBean {
	public ConfigBean01() {
		log.info("construct ConfigBean01");
	}

	@Resource
	private ComponentBean02 componentBean02;

	@Bean
	public HumanBean01 humanBean01() {
		return new HumanBean01();
	}

	/**
	 * 在构造方法之后被调用
	 */
	@PostConstruct
	public void postConstruct() {
		log.info("ConfigBean01 postConstruct");
	}

	/**
	 * 初始化方法，在@PostConstruct 之后被调用
	 *
	 * @throws Exception ex
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("afterPropertiesSet()");
	}


}
