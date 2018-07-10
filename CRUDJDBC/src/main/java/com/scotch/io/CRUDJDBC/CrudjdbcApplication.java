/*
 * 
 *  Spring provides JdbcTemplate class for database operations using JDBC. JdbcTemplate class is auto-configured and we 
 *  get its object using @Autowire annotation in our class that is annotated with spring stereotypes such as @Component. 
 *  JdbcTemplate provides methods such as queryForObject(), query(), update() etc to perform database operations. 
 *  In application.properties file we configure DataSource and connection pooling. Spring boot chooses tomcat pooling by default.
 *   Transaction management is performed by using spring @Transactional annotation either at class level or method level. 
 *   Spring JDBC provides RowMapper interface that is implemented to map a database table row with java object. 
 *   If table column name and ava entity fields name are same, then we can directly use Spring JDBC BeanPropertyRowMapper 
 *   to map a row with java object. 
 *  
 */
package com.scotch.io.CRUDJDBC;

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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import liquibase.integration.spring.SpringLiquibase;

@EnableConfigurationProperties({ LiquibaseProperties.class })
@EnableAutoConfiguration(exclude = LiquibaseAutoConfiguration.class)
@SpringBootApplication
public class CrudjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjdbcApplication.class, args);
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
	
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
