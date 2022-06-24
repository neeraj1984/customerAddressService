package com.microservice.customer.address;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 * this class is another way to implement DB connection by explicitly reading
 * configuration from prop file
 * 
 * By default spring boot does from reading the application.properties file(without this class)
 * 
 * Not using this class
 * 
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.microservice.customer.address")
@PropertySource(value="classpath:application.properties")
public class CommonDBConfig {

	@Autowired
    Environment environment;
	

	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.microservice.customer.address");
        //sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
	

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jobsdemo?allowPublicKeyRetrieval=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        return dataSource;
    }
     

}
