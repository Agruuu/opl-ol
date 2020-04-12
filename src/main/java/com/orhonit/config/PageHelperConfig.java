package com.orhonit.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {
	
	
	@Bean
	public PageHelper createPageHelper() {
		return new PageHelper();
	}

}
