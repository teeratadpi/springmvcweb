package com.service.mvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "com.service.mvc.repository")
@EnableWebMvc
public class AppConfig{

	 @Autowired
	    private Environment env;


	    Properties jpaProperties() {
	        return new Properties() {
	            {
	                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	                setProperty("hibernate.dialect", env.getProperty("hibernate.dialect")); //allows Hibernate to generate SQL optimized for a particular relational database.
	                setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
	            }
	        };
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	    {
	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setGenerateDdl(true);
	        vendorAdapter.setShowSql(true);

	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setDataSource(dataSource());
	        factory.setJpaVendorAdapter(vendorAdapter);
	        factory.setJpaProperties(jpaProperties());
	        factory.setPackagesToScan("com.service.mvc");

	        //factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
	        return factory;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager()
	    {
	        EntityManagerFactory factory = entityManagerFactory().getObject();
	        return new JpaTransactionManager(factory);
	    }

	    @Bean
	    public HibernateExceptionTranslator hibernateExceptionTranslator(){
	        return new HibernateExceptionTranslator();
	    }


	    @Bean
	    public DataSource dataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getProperty("jdbc.url"));
	        dataSource.setUsername(env.getProperty("jdbc.username"));
	        dataSource.setPassword(env.getProperty("jdbc.password"));

	        return dataSource;
	    }
}
