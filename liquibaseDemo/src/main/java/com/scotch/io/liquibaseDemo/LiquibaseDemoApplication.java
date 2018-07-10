package com.scotch.io.liquibaseDemo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import liquibase.integration.spring.SpringLiquibase;

@EnableConfigurationProperties({ LiquibaseProperties.class })
@EnableAutoConfiguration(exclude = LiquibaseAutoConfiguration.class)
@SpringBootApplication
public class LiquibaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseDemoApplication.class, args);
	}
	
	@ConditionalOnProperty(prefix = "spring.liquibase", name = {"enabled"})
	@Bean
	public SpringLiquibase liquibase(LiquibaseProperties liquibaseProperties, DataSource dataSource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog(liquibaseProperties.getChangeLog());
		liquibase.setDataSource(dataSource);
		liquibase.setDropFirst(liquibaseProperties.isDropFirst());
		liquibase.setContexts(liquibaseProperties.getContexts());
		liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
		liquibase.setShouldRun(liquibaseProperties.isEnabled());
		liquibase.setLabels(liquibaseProperties.getLabels());
		liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
		liquibase.setRollbackFile(liquibaseProperties.getRollbackFile());
		return liquibase;
	}
	
}
