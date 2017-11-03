

package com.qts.employeeprojectbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages= {"com.qts.employeeprojectbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Change below based on the DBMS you choose
	
	//H2 Properties

	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/mysql57";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "!23Qweasdzxc";
	
	
	//MYSQL Properties
	
	/*private final static String DATABASE_URL = "jdbc:mysql//localhost:3306/mysql57";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MYSQL5Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "!23Qweasdzxc";
	*/
	
	//dataSource bean will be available
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//Providing database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//SessionFactory Bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.qts.employeeprojectbackend.dto");
		return builder.buildSessionFactory();
	}
	
	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	
	//transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
