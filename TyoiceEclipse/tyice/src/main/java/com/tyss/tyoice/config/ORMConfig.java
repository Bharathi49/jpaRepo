package com.tyss.tyoice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {

	@Bean(name = "entityManagerFactory")
	public LocalEntityManagerFactoryBean ormConfig() {
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("ty_tyoice");
		return bean;
	}

}
