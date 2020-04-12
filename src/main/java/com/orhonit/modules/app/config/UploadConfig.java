package com.orhonit.modules.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "upload")
@Component
@Data
public class UploadConfig {
	
	private String path;
	
	private String caseCatalogPath;
	
	private String temp;
	
	private String serverUrl;
}
