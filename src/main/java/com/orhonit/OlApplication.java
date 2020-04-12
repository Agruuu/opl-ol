package com.orhonit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.orhonit.datasources.DynamicDataSourceConfig;

/**
 * io.netty.buffer.
 *
 * @author zhao
 * @date 2018/11/01 上午11:58:24
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class OlApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OlApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OlApplication.class);
    }
}
