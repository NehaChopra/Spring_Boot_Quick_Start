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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjdbcApplication.class, args);
	}
}
