package com.iemr.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.iemr.common.utils.IEMRApplBeans;

/**
 * @author VI314759
 *
 */
@SpringBootApplication
public class CommonApplication extends SpringBootServletInitializer {
	/**
	 * @return
	 */
	@Bean
	public IEMRApplBeans instantiateBeans() {
		return new IEMRApplBeans();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(commonApplication, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(new Class[] { CommonApplication.class });
	}

	private static Class<CommonApplication> commonApplication = CommonApplication.class;
}
