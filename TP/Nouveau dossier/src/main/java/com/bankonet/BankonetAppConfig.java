package com.bankonet;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@ImportResource(value = { "BeansConfig.xml","BeansConfig-MVC.xml" })
@ComponentScan(basePackages="com.bankonet",excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
@PropertySource("classpath:/properties/jdbc.properties")
@EnableTransactionManagement
public class BankonetAppConfig {
	
	@Value("${jdbc.username}")
	private String username; 
	
	@Value("${jdbc.password}")
	private String password; 
	
	@Value("${jdbc.url}")
	private String url; 
	
	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
			
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		
		return dataSource;
	}
	
	@Bean 
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager jTM = new JpaTransactionManager();
		jTM.setEntityManagerFactory(entityManagerFactory());
		return jTM;
	}

	@Bean
	public  EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf =  new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("MY_PU");
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.bankonet.model");
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setJpaDialect(jpaDialect());
			Map<String, String> props = new HashMap<String, String>();
				props.put("eclipselink.weaving", "static");
				props.put("eclipselink.ddl-generation","create-or-extend-tables");
		emf.setJpaPropertyMap(props);
		emf.afterPropertiesSet();
		return emf.getObject();
	}
	

	public EclipseLinkJpaVendorAdapter jpaVendorAdapter() {
		EclipseLinkJpaVendorAdapter jva = new EclipseLinkJpaVendorAdapter();
		jva.setShowSql(true);
		jva.setGenerateDdl(true);
		jva.setDatabasePlatform("org.eclipse.persistence.platform.database.MySQLPlatform");
		return jva;
	}
	

	public EclipseLinkJpaDialect jpaDialect() {
		return new EclipseLinkJpaDialect();
	}

}
